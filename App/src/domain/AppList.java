package domain;

import java.util.ArrayList;

public class AppList {
	
	public static String toList(ArrayList<Application> list){
		String s = null;
		for(int i = 0; i < list.size(); i++){
			s = s + list.get(i)+"\n\n";
		}
		return s;
		
	}

}
