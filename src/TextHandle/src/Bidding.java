import java.util.*;

public class Bidding{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 1;
		boolean isCancel[] = new boolean[5005];
		for (int i = 0; i < isCancel.length; i++) {
			isCancel[i] = false;
		}
		Stock buy[] = new Stock[5005];
		Stock sell[] = new Stock[5005];
		int buyNum = 0;
		int sellNum = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.trim().length() == 0) {
				break;
			}
			if (s.contains("buy")) {
				buy[buyNum++] = new Stock(num++, 
						Float.parseFloat(s.split(" ")[1]), Long.parseLong(s.split(" ")[2]));
			} else if (s.contains("sell")) {
				sell[sellNum++] = new Stock(num++, 
						Float.parseFloat(s.split(" ")[1]), Long.parseLong(s.split(" ")[2]));

			} else if (s.contains("cancel")) {
				isCancel[Integer.parseInt(s.split(" ")[1])] = true;
				num++;
			}
		}
		Arrays.sort(buy, 0, buyNum);
		Arrays.sort(sell, 0, sellNum);
		int indexBuy = buyNum - 1;
		float resultPrice = 0;
		long resultNum = 0;
		long tempNumBuy = 0;
		while (indexBuy >= 0) {
			if (!isCancel[buy[indexBuy].id]) {
				float tempPrice = buy[indexBuy].price;
				tempNumBuy += buy[indexBuy].num;
				long tempNumSell = 0;
				for (int i = 0; i < sellNum; i++) {
					if ((!isCancel[sell[i].id]) && sell[i].price <= tempPrice) {
						tempNumSell += sell[i].num;
					}
				}
				long tempResultNum = Math.min(tempNumBuy, tempNumSell);
				if (tempResultNum > resultNum) {
					resultPrice = tempPrice;
					resultNum = tempResultNum;
				}
			} else {

			}
			indexBuy--;
		}
		System.out.printf("%5.2f  ", resultPrice);
		System.out.println(resultNum);
		sc.close();
	}

}

class Stock implements Comparable<Stock> {
	int id;
	float price;
	long num;

	public Stock(int id, float price, long num) {
		super();
		this.id = id;
		this.price = price;
		this.num = num;
	}

	@Override
	public int compareTo(Stock o) {
		// TODO Auto-generated method stub
		if (price < o.price) {
			return -1;
		} else if (price == o.price) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "  id:" + id + " price:" + price + " num:" + num;
	}

}