package com.utc.util;

import java.beans.PropertyEditorSupport;

public class NameEditor extends PropertyEditorSupport{

	@Override
public void setAsText(String sname) throws IllegalArgumentException {

	if(sname.contains("Mr.")||sname.contains("Ms."))
	{
		setValue(sname);
	}
	else
	{
		sname="Ms."+sname;
		setValue(sname);
	}
	

}
}
