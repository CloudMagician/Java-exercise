package CSP;

import java.util.*;

class IPpref {
	public long ip;
	public int len;
	public IPpref(long ip, int len) {
		this.ip=ip;
		this.len=len;
	}
}

public class CIDRMerge {

	public static void main(String[] args) {
		
		Scanner reader=new Scanner(System.in);
		int n=Integer.parseInt(reader.nextLine());
		List<IPpref> a = new ArrayList<>(Collections.unmodifiableList(new ArrayList<>()));
		for(int d=0;d<n;d++) {
			
			String ip=reader.nextLine();
			
			long Ip=0;   //实际ip值
			int len;   //掩码长度
			int j;
			int index=ip.indexOf("/");
			if(index!=-1) {
				
				String[] b= ip.split("/");
				len=Integer.parseInt(b[1]);
				String str= b[0];
				if(str.contains(".")) b=str.split("\\.");
				else b=new String[] {str};
				
				j=1<<(8*(4-b.length));
				for(int i=b.length-1;i>=0;i--) {
					Ip+=Long.parseLong(b[i])*j;
					j<<=8;
				}
			}else {
				String[] b= new String[]{ip};
				if(ip.contains(".")) b=ip.split("\\.");
				j=1<<(8*(4-b.length));
				len=b.length*8;
				for(int i=b.length-1;i>=0;i--) {
					Ip+=Long.parseLong(b[i])*j;
					j<<=8;
				}
			}
			IPpref ipPref=new IPpref(Ip,len);
			int m=0;
			int n1=a.size()-1;
			while(true){
				
				if(m>n1) {
					a.add(m, ipPref);
					break;
				}
				if(m==n1) {
					if(a.get(m).ip>Ip) a.add(m, ipPref);
					else if(a.get(m).ip<Ip) a.add(m+1,ipPref);
					else if(a.get(m).len>len) a.set(m, ipPref);
					break;
				}
				
				int k=(m+n1)/2;
				if(a.get(k).ip>Ip) n1=k-1;
				else if(a.get(k).ip<Ip) m=k+1;
				else if(a.get(k).len>len) {
					a.set(k, ipPref);
					break;
				}else break;
			}
		}
		int size=a.size()-1;
		int max;
		long f,L,mask;
		for(int k=0;k<size;) {
			max=32-Math.min(a.get(k).len, a.get(k+1).len);
			mask=-1L<<max;
			f=a.get(k).ip&mask;
			L=a.get(k+1).ip&mask;
			if(f==L) {
				a.set(k, new IPpref(f,32-max));
				a.remove(k+1);
				size--;
				continue;
			}
			k++;
		}
		
		for(int k=0;k<size;) {
			if(a.get(k).len!=a.get(k+1).len) {
				k++;
				continue;
			}
			
			max=33-a.get(k).len;
			mask=-1L<<max;
			f=a.get(k).ip&mask;
			L=a.get(k+1).ip&mask;
			if(f==L) {
				a.set(k, new IPpref(f,32-max));
				a.remove(k+1);
				size--;
				if(k!=0) k--;
				continue;
			}
			k++;
		}
		
		reader.close();
		long s,a0,a1,a2,a3;
		String str;
		for(IPpref ip:a) {
			s=ip.ip>>8;
			a0=ip.ip%256;
			a1=s%256;
			s>>=8;
			a2=s%256;
			s>>=8;
			a3=s%256;
			str=a3+"."+a2+"."+a1+"."+a0+"/"+ip.len;
			System.out.println(str);
		}

	}
}