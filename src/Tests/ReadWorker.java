package Tests;

import java.io.*;
import java.util.*;

public final class ReadWorker {
	private class Worker {
		String name;
		int age;
		int salary;
	}
	
	private List<Worker> list;
	private static Scanner s;
	
	public ReadWorker() {	
		list = new LinkedList<Worker>();
	}
	
	public List<Worker> readFromFile(File file) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(file));
		String temps = null;
        while((temps=in.readLine())!=null){
        	Worker tempw = new Worker();
            tempw.name = temps.split(" ")[0];
            tempw.age = Integer.parseInt(temps.split(" ")[1]);
            tempw.salary = Integer.parseInt(temps.split(" ")[2]);
            list.add(tempw);
        }
        in.close();
        return list;        
	}
	
	public void write() {
		for (Iterator<Worker> iterator = list.iterator(); iterator.hasNext();) {
			Worker worker = (Worker) iterator.next();
			System.out.println("name="+worker.name+",age="+worker.age+",salary="+worker.salary);
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("input the name of file:");
		s = new Scanner(System.in);
		String filename = s.nextLine();
		ReadWorker test = new ReadWorker();
		test.readFromFile(new File(filename));
		test.write();
	}
}
