/**********************************************************************
* This file is part of iDempiere ERP Open Source                      *
* http://www.idempiere.org                                            *
*                                                                     *
* Copyright (C) Contributors                                          *
*                                                                     *
* This program is free software; you can redistribute it and/or       *
* modify it under the terms of the GNU General Public License         *
* as published by the Free Software Foundation; either version 2      *
* of the License, or (at your option) any later version.              *
*                                                                     *
* This program is distributed in the hope that it will be useful,     *
* but WITHOUT ANY WARRANTY; without even the implied warranty of      *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
* GNU General Public License for more details.                        *
*                                                                     *
* You should have received a copy of the GNU General Public License   *
* along with this program; if not, write to the Free Software         *
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
* MA 02110-1301, USA.                                                 *
*                                                                     *
* Contributors:                                                       *
* - Diego Ruiz - Universidad Distrital Francisco Jose de Caldas       *
**********************************************************************/

package org.kanbanboard.process;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.compiere.util.Msg;
import org.kanbanboard.model.MKanbanBoard;
import org.kanbanboard.model.MKanbanSwimlane;

public class CreateSwimlanesProcess extends SvrProcess {

	private int M_KanbanBoard_ID;

	@Override
	protected void prepare() {
		M_KanbanBoard_ID = getRecord_ID();
	}

	@Override
	protected String doIt() throws Exception {
		if (M_KanbanBoard_ID == 0)
			throw new IllegalArgumentException("KanbanBoard_ID == 0");

		
		MKanbanBoard kanbanBoard = new MKanbanBoard(getCtx(), M_KanbanBoard_ID, get_TrxName());
		if (kanbanBoard.getKDB_SLColumnList_ID() == 0 && kanbanBoard.getKDB_SLColumnTable_ID() == 0)
			throw new IllegalArgumentException(Msg.getMsg(getCtx(), "KDB_SwimlanesError"));
		
		KanbanProcessHelper processHelper = new KanbanProcessHelper(kanbanBoard, false);
		String sqlSelect = processHelper.getSQLStatement(); 

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int seqno = processHelper.getSeqNo(get_TrxName());
		int cnt = 0;
		try {
			pstmt = DB.prepareStatement(sqlSelect, get_TrxName());
			pstmt.setInt(1, processHelper.getSQLParameter());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String swimlaneName = rs.getString(1);
				String reference = rs.getString(2);

				boolean exists = false;
				for (MKanbanSwimlane swimlane : kanbanBoard.getSwimlanes()) {
					if (reference.equals(swimlane.getDatabaseValue())) {
						exists = true;
						break;
					}
				}

				if (!exists) {
					seqno = seqno+10;
					MKanbanSwimlane kanbanSwimlane = new MKanbanSwimlane(getCtx(), 0, get_TrxName());
					kanbanSwimlane.setKDB_KanbanBoard_ID(M_KanbanBoard_ID);
					kanbanSwimlane.setName(swimlaneName);
					if (processHelper.isRefList())
						kanbanSwimlane.setKDB_SwimlaneListValue(reference);
					else
						kanbanSwimlane.setKDB_SwimlaneTableID(reference);

					kanbanSwimlane.setSeqNo(seqno);
					kanbanSwimlane.saveEx();
					cnt++;
				}
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, sqlSelect.toString(), e);
			throw e;
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		return "@KDB_KanbanSwimlane_ID@ @Inserted@=" + cnt;
	}
}
