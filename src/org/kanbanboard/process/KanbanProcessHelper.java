package org.kanbanboard.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.util.DB;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.kanbanboard.model.MKanbanBoard;
import org.kanbanboard.model.MKanbanStatus;
import org.kanbanboard.model.MKanbanSwimlane;

public class KanbanProcessHelper {
	
	private MKanbanBoard kanbanBoard;
	private boolean isStatusSQL;
	private boolean isRefList;
	private MColumn column;
	
	
	public KanbanProcessHelper(MKanbanBoard kanbanBoard, boolean isStatusSQL) {
		this.kanbanBoard = kanbanBoard;
		this.isStatusSQL = isStatusSQL;
		
		int columnListID = isStatusSQL ? kanbanBoard.getKDB_ColumnList_ID() : kanbanBoard.getKDB_SLColumnList_ID();
		int columnTableID = isStatusSQL ? kanbanBoard.getKDB_ColumnTable_ID() : kanbanBoard.getKDB_SLColumnTable_ID();
		
		if (columnListID != 0) {
			column = MColumn.get(columnListID);
			isRefList= true;
		} else if (columnTableID != 0) {
			column = MColumn.get(columnTableID);
			isRefList = false;
		} else {
			throw new AdempiereException("Either the column list or the column table must be assigned");
		}
	}

	/***
	 * Get SQL statement to create Statuses or Swimlanes
	 * @param kanbanBoard parent Kanban Board
	 * @param isStatusSQL true if it's use for status, false for swimlanes
	 * @return
	 */
	public String getSQLStatement() {
		StringBuilder sqlSelect = new StringBuilder();
		
		if (isRefList) {
			//Reference List
			if (column.getAD_Reference_ID() == DisplayType.List) {
				if (column.getAD_Reference_Value_ID() != 0) {
					// Reference Key is not a table but a RefList
					sqlSelect.append("SELECT DISTINCT Name, Value FROM AD_Ref_List ")
						.append("WHERE AD_Reference_ID = ? AND IsActive = 'Y'");
				}
			}
		} else {
			//Table, Table direct or Search Reference
			if (column.getAD_Reference_ID() == DisplayType.Table ||
					column.getAD_Reference_ID() == DisplayType.Search ||
					column.getAD_Reference_ID() == DisplayType.TableDir) {					

				MTable table =  MTable.get(Env.getCtx(), column.getReferenceTableName());
				String keyColumns[] = table.getKeyColumns();
				String identifierColumns[] = table.getIdentifierColumns();

				sqlSelect.append("SELECT DISTINCT ").append(identifierColumns[0])
					.append(", ")
					.append(keyColumns[0])
					.append(" FROM ").append(table.getTableName())
					.append(" WHERE ")
					.append(" AD_Client_ID IN (0, ?) AND")
					.append(" IsActive = 'Y'");
			}
		}

		return sqlSelect.toString();
	}
	
	public int getSQLParameter() {
		return isRefList() ? column.getAD_Reference_Value_ID() : kanbanBoard.getAD_Client_ID();
	}

	public boolean isRefList() {
		return isRefList;
	}

	public int getSeqNo(String trxName) {
		String tableName = isStatusSQL ? MKanbanStatus.Table_Name : MKanbanSwimlane.Table_Name;
		return DB.getSQLValueEx(trxName, "SELECT MAX(SeqNo) FROM " + tableName + " WHERE KDB_KanbanBoard_ID=?", kanbanBoard.getKDB_KanbanBoard_ID());
	}
}