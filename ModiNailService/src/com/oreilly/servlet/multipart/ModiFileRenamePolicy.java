package com.oreilly.servlet.multipart;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModiFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		// TODO Auto-generated method stub
		String name = f.getName();
		String body = null;
		String ext = null;
		long currentTime = System.currentTimeMillis();
        SimpleDateFormat simDf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		int dot = name.lastIndexOf(".");
		if(dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		}else {
			body = name;
			ext="";
		}
		
		String tempName = "modi_gel_"+simDf.format(new Date(currentTime))+ext;
		f = new File(f.getParent(),tempName);
		
		if(createNewFile(f)) {
			return f;
		}
		
		int count = 0;
		while(!createNewFile(f) && count < 9999) {
			count++;
			String newName = "modi_gel_"+simDf.format(new Date(currentTime))+"_"+count+ext;
			f = new File(f.getParent(),newName);
		}
		
		return f;
	}
	
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		}catch(Exception ex) {
			return false;
		}
	}

}
