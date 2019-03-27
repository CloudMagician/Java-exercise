import java.util.*;

public class CommandOptions {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		
		//标记命令
		List<Command> l=new ArrayList<Command>();
		for(int i=0;i<s.length();i++) {//输入命令
			if(i!=s.length()-1) {
				if(s.charAt(i+1)!=':'){
					Command c=new Command(s.charAt(i),false);
					l.add(c);
				}
				else {
					Command c=new Command(s.charAt(i),true);
					l.add(c);
					i++;
				}
			}
			else {
				Command c=new Command(s.charAt(i),false);
				l.add(c);
			}
		}
		
		//几行命令
		int n=Integer.parseInt(sc.nextLine());
		
		//读取命令并输出
		for(int i=0;i<n;i++) {
			String sTemp=sc.nextLine();
			System.out.print("Case "+(i+1)+":");
			String arrSTemp[]=sTemp.split(" ");
			
			List<SaveCom> comList=new ArrayList<SaveCom>();
			for(int j=1;j<arrSTemp.length;j++) {
				if(arrSTemp[j].length()==2&&
						arrSTemp[j].charAt(0)=='-'&&
						l.contains(new Command(arrSTemp[j].charAt(1),false))&&
						j!=arrSTemp.length-1) {//如果这个命令存在，而且j!=arrStemp.length-1，如果j==arrStemp.length-1 如果该命令是不带参数的选项，那就可以直接输出，否则，如果该参数是带参数的选项，因为他已经是最后一位，所以没有参数和他匹配，那么应该结束搜索
					int index=l.indexOf(new Command(arrSTemp[j].charAt(1),false));
					Command tt=l.get(index);
					if(tt.isHaveParameters==false) {//该命令不要参数
						SaveCom save=new SaveCom(arrSTemp[j].charAt(1),false, null);
						if(comList.contains(save)) {
							comList.remove(save);
							comList.add(save);
						}
						else {
							comList.add(save);
						}
					}
					else {//该命令需要参数
						int flag=1;
						for(int k=0;k<arrSTemp[j+1].length();k++) {
							if(arrSTemp[j+1].charAt(k)=='-') {
								
							}
							else if(arrSTemp[j+1].charAt(k)>='0'&&arrSTemp[j+1].charAt(k)<='9') {
								
							}
							else if(arrSTemp[j+1].charAt(k)>='a'&&arrSTemp[j+1].charAt(k)<='z') {
								
							}
							else {
								flag=0;
								break;
							}
						}
						if(flag==1) {
							SaveCom save=new SaveCom(arrSTemp[j].charAt(1),true, arrSTemp[j+1]);
							if(comList.contains(save)) {
								comList.remove(save);
								comList.add(save);
							}
							else {
								comList.add(save);
							}
							j++;
						}
						else {
							break;
						}
					}
				}
				// 最后一个的特殊处理
				else if(arrSTemp[j].length()==2&&
						arrSTemp[j].charAt(0)=='-'&&
						l.contains(new Command(arrSTemp[j].charAt(1),false))&&
						j==arrSTemp.length-1) {
					int index=l.indexOf(new Command(arrSTemp[j].charAt(1),false));
					Command tt=l.get(index);
					if(tt.isHaveParameters==false) {//该命令不要参数
						SaveCom save=new SaveCom(arrSTemp[j].charAt(1),false, null);
						if(comList.contains(save)) {
							comList.remove(save);
							comList.add(save);
						}
						else {
							comList.add(save);
						}
					}
					else {
						break;
					}
				}
				else {
					break;
				}
			}
			//字典排序
			Collections.sort(comList);
			for(int j=0;j<comList.size();j++) {
				comList.get(j).output();
			}
			System.out.println();
		}
		sc.close();
	}
}
class SaveCom implements Comparable<SaveCom>{
	char command;
	boolean isHaveParameters;
	String parameter;
	public SaveCom(char command, boolean isHaveParameters, String parameter) {
		super();
		this.command = command;
		this.isHaveParameters = isHaveParameters;
		this.parameter = parameter;
	}
	@Override
	public int compareTo(SaveCom o) {
		// TODO Auto-generated method stub
		return command-o.command;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.command==((SaveCom)obj).command;
	}
	public void output() {
		if(isHaveParameters==false) {
			System.out.print(" -"+command);
		}
		else {
			System.out.print(" -"+command+" "+parameter);
		}
		//System.out.println();
	}
}
class Command{
	char command;
	boolean isHaveParameters;
	public Command(char command, boolean isHaveParameters) {
		this.command = command;
		this.isHaveParameters = isHaveParameters;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this.command==((Command)obj).command) {
			return true;
		}
		else {
			return false;
		}
	}
}