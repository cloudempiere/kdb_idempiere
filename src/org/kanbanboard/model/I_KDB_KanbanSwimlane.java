/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.kanbanboard.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for KDB_KanbanSwimlane
 *  @author iDempiere (generated) 
 *  @version Release 8.2
 */
@SuppressWarnings("all")
public interface I_KDB_KanbanSwimlane 
{

    /** TableName=KDB_KanbanSwimlane */
    public static final String Table_Name = "KDB_KanbanSwimlane";

    /** AD_Table_ID=1000009 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 4 - System 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(4);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name InlineStyle */
    public static final String COLUMNNAME_InlineStyle = "InlineStyle";

	/** Set Inline Style.
	  * CSS Inline Style
	  */
	public void setInlineStyle (String InlineStyle);

	/** Get Inline Style.
	  * CSS Inline Style
	  */
	public String getInlineStyle();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsShowEmpty */
    public static final String COLUMNNAME_IsShowEmpty = "IsShowEmpty";

	/** Set Show If Empty.
	  * The Swimlane will be shown in the kanban board even when there are not cards attached to it
	  */
	public void setIsShowEmpty (boolean IsShowEmpty);

	/** Get Show If Empty.
	  * The Swimlane will be shown in the kanban board even when there are not cards attached to it
	  */
	public boolean isShowEmpty();

    /** Column name KDB_KanbanBoard_ID */
    public static final String COLUMNNAME_KDB_KanbanBoard_ID = "KDB_KanbanBoard_ID";

	/** Set Kanban Board	  */
	public void setKDB_KanbanBoard_ID (int KDB_KanbanBoard_ID);

	/** Get Kanban Board	  */
	public int getKDB_KanbanBoard_ID();

	public org.kanbanboard.model.I_KDB_KanbanBoard getKDB_KanbanBoard() throws RuntimeException;

    /** Column name KDB_KanbanSwimlane_ID */
    public static final String COLUMNNAME_KDB_KanbanSwimlane_ID = "KDB_KanbanSwimlane_ID";

	/** Set Kanban Swimlane	  */
	public void setKDB_KanbanSwimlane_ID (int KDB_KanbanSwimlane_ID);

	/** Get Kanban Swimlane	  */
	public int getKDB_KanbanSwimlane_ID();

    /** Column name KDB_KanbanSwimlane_UU */
    public static final String COLUMNNAME_KDB_KanbanSwimlane_UU = "KDB_KanbanSwimlane_UU";

	/** Set KDB_KanbanSwimlane_UU	  */
	public void setKDB_KanbanSwimlane_UU (String KDB_KanbanSwimlane_UU);

	/** Get KDB_KanbanSwimlane_UU	  */
	public String getKDB_KanbanSwimlane_UU();

    /** Column name KDB_SwimlaneListValue */
    public static final String COLUMNNAME_KDB_SwimlaneListValue = "KDB_SwimlaneListValue";

	/** Set List Value	  */
	public void setKDB_SwimlaneListValue (String KDB_SwimlaneListValue);

	/** Get List Value	  */
	public String getKDB_SwimlaneListValue();

    /** Column name KDB_SwimlaneTableID */
    public static final String COLUMNNAME_KDB_SwimlaneTableID = "KDB_SwimlaneTableID";

	/** Set Table ID	  */
	public void setKDB_SwimlaneTableID (String KDB_SwimlaneTableID);

	/** Get Table ID	  */
	public String getKDB_SwimlaneTableID();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

    /** Column name SwimlaneAlias */
    public static final String COLUMNNAME_SwimlaneAlias = "SwimlaneAlias";

	/** Set Swimlane Alias	  */
	public void setSwimlaneAlias (String SwimlaneAlias);

	/** Get Swimlane Alias	  */
	public String getSwimlaneAlias();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
