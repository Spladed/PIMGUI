package Display;

import java.util.Calendar;

public class Cal {
	 private static int space;		//1��ǰ�Ŀ�λ
	 private static int num;		//һ���µ�����
	 private static Object[][] obj;
	
	public static Object[][] Solution(){
        Calendar now=Calendar.getInstance();
        return Solution(now.get(Calendar.MONTH)+1,now.get(Calendar.YEAR));        
    }
	
	public static Object[][] Solution(int m,int y){
		System.out.println(y+" "+m);
        Calendar c=Calendar.getInstance();
        c.set(y,m-1,1);
        
        //c.get(Calendar.DAY_OF_WEEK)��ȡ�˱��µ�1�����ܼ���1�������գ�2������һ......7����������
        space=c.get(Calendar.DAY_OF_WEEK)-1;
        
        //c.getActualMaximum(Calendar.DAY_OF_MONTH)��ȡ���µ�����
        num=c.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        //�������
        fillData(m,y);
        return obj;
    }
	
	private static void  fillData(int m,int y){
		int date=1;
		int totalDay=space+num;
		int rowNum=totalDay/7;
		int mod=totalDay%7;
		if(mod != 0)
			rowNum+=1;
		obj=new Object[rowNum][7];
		
		//��obj����ʼ��
		for(int i=0;i<rowNum;i++)
			for(int j=0;j<7;j++)
				obj[i][j]="";
		
		for(int week=0;week<rowNum ;week++) {
			for(int day=0;day<7;day++) {
				if(space!=0) {
					day=space;
					space=0;
				}
				if(date<=num) {
					obj[week][day]=date;
					date++;
				}
				else
					break;
			}
		}
    }
	
	public static void main(String[] args){
        Cal cc=new Cal();        
        Object[][] obj=cc.Solution();
        for(Object[] o:obj) {
        	for(Object oo:o)
        		System.out.print(oo);
        	System.out.println();
        }
    }
}
