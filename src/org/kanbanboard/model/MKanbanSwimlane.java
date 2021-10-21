package org.kanbanboard.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MKanbanSwimlane extends X_KDB_KanbanSwimlane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -848201722282713881L;

	public MKanbanSwimlane(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MKanbanSwimlane(Properties ctx, int KDB_KanbanSwimlane_ID, String trxName) {
		super(ctx, KDB_KanbanSwimlane_ID, trxName);
	}
	
	public String getDatabaseValue() {
		return getKDB_SwimlaneListValue() != null ? getKDB_SwimlaneListValue() :
			getKDB_SwimlaneTableID();
	}

}
