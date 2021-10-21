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
/** Generated Model - DO NOT CHANGE */
package org.kanbanboard.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for KDB_KanbanSwimlane
 *  @author iDempiere (generated) 
 *  @version Release 8.2 - $Id$ */
public class X_KDB_KanbanSwimlane extends PO implements I_KDB_KanbanSwimlane, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20211021L;

    /** Standard Constructor */
    public X_KDB_KanbanSwimlane (Properties ctx, int KDB_KanbanSwimlane_ID, String trxName)
    {
      super (ctx, KDB_KanbanSwimlane_ID, trxName);
      /** if (KDB_KanbanSwimlane_ID == 0)
        {
			setIsShowEmpty (false);
// N
			setKDB_KanbanBoard_ID (0);
			setKDB_KanbanSwimlane_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_KDB_KanbanSwimlane (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 4 - System 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_KDB_KanbanSwimlane[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Inline Style.
		@param InlineStyle 
		CSS Inline Style
	  */
	public void setInlineStyle (String InlineStyle)
	{
		set_Value (COLUMNNAME_InlineStyle, InlineStyle);
	}

	/** Get Inline Style.
		@return CSS Inline Style
	  */
	public String getInlineStyle () 
	{
		return (String)get_Value(COLUMNNAME_InlineStyle);
	}

	/** Set Show If Empty.
		@param IsShowEmpty 
		The Swimlane will be shown in the kanban board even when there are not cards attached to it
	  */
	public void setIsShowEmpty (boolean IsShowEmpty)
	{
		set_Value (COLUMNNAME_IsShowEmpty, Boolean.valueOf(IsShowEmpty));
	}

	/** Get Show If Empty.
		@return The Swimlane will be shown in the kanban board even when there are not cards attached to it
	  */
	public boolean isShowEmpty () 
	{
		Object oo = get_Value(COLUMNNAME_IsShowEmpty);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	public org.kanbanboard.model.I_KDB_KanbanBoard getKDB_KanbanBoard() throws RuntimeException
    {
		return (org.kanbanboard.model.I_KDB_KanbanBoard)MTable.get(getCtx(), org.kanbanboard.model.I_KDB_KanbanBoard.Table_Name)
			.getPO(getKDB_KanbanBoard_ID(), get_TrxName());	}

	/** Set Kanban Board.
		@param KDB_KanbanBoard_ID Kanban Board	  */
	public void setKDB_KanbanBoard_ID (int KDB_KanbanBoard_ID)
	{
		if (KDB_KanbanBoard_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_KDB_KanbanBoard_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_KDB_KanbanBoard_ID, Integer.valueOf(KDB_KanbanBoard_ID));
	}

	/** Get Kanban Board.
		@return Kanban Board	  */
	public int getKDB_KanbanBoard_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_KDB_KanbanBoard_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Kanban Swimlane.
		@param KDB_KanbanSwimlane_ID Kanban Swimlane	  */
	public void setKDB_KanbanSwimlane_ID (int KDB_KanbanSwimlane_ID)
	{
		if (KDB_KanbanSwimlane_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_KDB_KanbanSwimlane_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_KDB_KanbanSwimlane_ID, Integer.valueOf(KDB_KanbanSwimlane_ID));
	}

	/** Get Kanban Swimlane.
		@return Kanban Swimlane	  */
	public int getKDB_KanbanSwimlane_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_KDB_KanbanSwimlane_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set KDB_KanbanSwimlane_UU.
		@param KDB_KanbanSwimlane_UU KDB_KanbanSwimlane_UU	  */
	public void setKDB_KanbanSwimlane_UU (String KDB_KanbanSwimlane_UU)
	{
		set_Value (COLUMNNAME_KDB_KanbanSwimlane_UU, KDB_KanbanSwimlane_UU);
	}

	/** Get KDB_KanbanSwimlane_UU.
		@return KDB_KanbanSwimlane_UU	  */
	public String getKDB_KanbanSwimlane_UU () 
	{
		return (String)get_Value(COLUMNNAME_KDB_KanbanSwimlane_UU);
	}

	/** Set List Value.
		@param KDB_SwimlaneListValue List Value	  */
	public void setKDB_SwimlaneListValue (String KDB_SwimlaneListValue)
	{
		set_ValueNoCheck (COLUMNNAME_KDB_SwimlaneListValue, KDB_SwimlaneListValue);
	}

	/** Get List Value.
		@return List Value	  */
	public String getKDB_SwimlaneListValue () 
	{
		return (String)get_Value(COLUMNNAME_KDB_SwimlaneListValue);
	}

	/** Set Table ID.
		@param KDB_SwimlaneTableID Table ID	  */
	public void setKDB_SwimlaneTableID (String KDB_SwimlaneTableID)
	{
		set_ValueNoCheck (COLUMNNAME_KDB_SwimlaneTableID, KDB_SwimlaneTableID);
	}

	/** Get Table ID.
		@return Table ID	  */
	public String getKDB_SwimlaneTableID () 
	{
		return (String)get_Value(COLUMNNAME_KDB_SwimlaneTableID);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Swimlane Alias.
		@param SwimlaneAlias Swimlane Alias	  */
	public void setSwimlaneAlias (String SwimlaneAlias)
	{
		set_Value (COLUMNNAME_SwimlaneAlias, SwimlaneAlias);
	}

	/** Get Swimlane Alias.
		@return Swimlane Alias	  */
	public String getSwimlaneAlias () 
	{
		return (String)get_Value(COLUMNNAME_SwimlaneAlias);
	}
}