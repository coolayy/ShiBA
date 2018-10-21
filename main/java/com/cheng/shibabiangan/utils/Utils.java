package com.cheng.shibabiangan.utils;

import static android.view.View.resolveSize;
import static com.cheng.shibabiangan.gameviews.MyGameView.isLegal;
import static com.cheng.shibabiangan.utils.Constant.ground;

import static com.cheng.shibabiangan.utils.Constant.groundgan;
import static com.cheng.shibabiangan.gameviews.MyGameView.ishesi;

import com.cheng.shibabiangan.gameviews.MyGameView.*;

public class Utils {
	 static boolean zuo=false;
	 static Move move;
	// 检查是否有五子连起来
//	public static boolean isWin(int x, int y) {
//		if (isHFive(x, y, 9) || isVFive(x, y, 9))
////				|| isLTFive(x, y, 9) || isRTFive(x, y, 9))
//			return true;
//		return false;
//
//	}
	//检查棋盘是否下满
	public static boolean  istotal() {
		int total = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (ground[x][y] != 0) {
					total++;

	               if (total>=81) {return true;}

				}
			}
		}
		return false;
	}
	public static int  heiqi() {
		int heizi = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (ground[x][y] == 2) {
					heizi++;

				}
			}
		}
		return heizi;
	}
	public static int  baiqi() {
		int baizi = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (ground[x][y] == 1) {
					baizi++;



				}
			}
		}
		return baizi;
	}

	public static int  baiwulu() {
		int baibai = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (isbaiwulu(x,y)) {
					baibai++;



				}
			}
		}
		return baibai;
	}

	public static int  heiwulu() {
		int heihei = 0;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				if (isheiwulu(x,y)) {
					heihei++;



				}
			}
		}
		return heihei;
	}
	public static int  heiwulua() {
		int heihei = 0;
				if (zuo==true) {
					heihei++;

		}
		return heihei;
	}

//	public static int gantotal(){
//		int c=0;
//		for (int  x = 0; x < 8; x++) {
//			for (int y = 0; y < 8; y++) {
//				if (isbaigan(x, y) || ishegan(x, y)) {
//					c++;
//				}
//			}
//		}
//		return c;
//	}

	public static int hesi(int x,int y){
		int z=0;
		 for (x = 0; x < 9; x++) {
			 for ( y = 0; y < 9; y++) {
				 if (ishesi(x,y)) {
					 z++;
				 }
			 }
		 }
		return z;
	}
	public  static int baisi(int x,int y){
		int b=0;
		for ( x = 0; x < 9; x++) {
			for ( y = 0; y < 9; y++) {
				if (isbaisi(x,y)) {
					b++;
				}
			}
		}
		return b;
	}
	public  static int baigan(int x,int y){
		int b=0;
		for ( x = 0; x < 8; x++) {
			for ( y = 0; y < 8; y++) {
				if (groundgan[y][x]==3){
					b++;
				}
			}
		}
		return b;
	}
	public  static int heigan(int x,int y){
		int b=0;
		for ( x = 0; x < 8; x++) {
			for ( y = 0; y < 8; y++) {
				if (groundgan[y][x]==4){
					b++;
				}
			}
		}
		return b;
	}
	public static boolean islegalmove(int x,int y){
		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				int a = x + i;
				int b = y + j;
				if (i*j==0&&isLegal(a, b) && ground[a][b] ==0 ) {
					return true;

				}
			}
		}

		return false;
	}



	public static boolean ishesi(int x, int y) {


		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				int a = x + i;
				int b = y + j;

				if (isLegal(a, b) && ground[a][b] == 2) {

					if (isLegal(a,b-i)&&isLegal(a-i,b)&& ground[a][b - j] == 2 ) {
						if (ground[a - i][b] == 2) {
							if ((i<=0&&j>=0)||(i>=0&&j>=0)||(i<=0&&j<=0)||(i>=0&&j<=0)) {
								int e=i,f=j;
								if (e==f&&Math.abs(e-f)<=1&&e*f!=0){
									if (ground[x][y] == 2) {



										if (e < 0 && f < 0) {
												return true;
										}else
										if (e < 0 && f > 0) {

																return true;
										}else
										if (e > 0 && f < 0) {
											return true;

										}else
										if (e > 0 && f> 0) {

												return true;
										}




									} else return false;
								}

							} else return false;
						}else break;
					}
					else return false;
				}
				else return false;

			}
		}

		return false;
	}

	public static boolean isbaisi(int x,int y){

		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				int a = x + i;
				int b = y + j;
				int c = x;
				int d = y;
				if (isLegal(a, b) && ground[a][b] == 1) {

					if (isLegal(a,b-i)&&isLegal(a-i,b)&& ground[a][b - j] == 1 ) {
						if (ground[a - i][b] == 1) {
							if ((i<=0&&j>=0)||(i>=0&&j>=0)||(i<=0&&j<=0)||(i>=0&&j<=0)) {
								int e=i,f=j;
								if (e==f&&Math.abs(e-f)<=1&&e*f!=0){
									if (ground[x][y] == 1) {


										if (e < 0 && f < 0) {
												return true;
										}else
										if (e < 0 && f > 0) {
												return true;
										}else
										if (e > 0 && f < 0) {
												return true;
										}else
										if (e > 0 && f> 0) {
												return true;
										}

									}
									else return false;
								}

							} else return false;
						}else break;
					}
					else return false;
				}
				else return false;

			}
		}
		return true;

	}

	public static boolean isbaiwulu(int x,int y){



		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if ((i == 0 && j == 0)||i*j!=0) {

					continue;

				}

				int a = x + i;
				int b = y + j;
				if (isLegal(a, b) && ground[a][b] != 0) {
					int c = i;
					int d = j;
					if(b==0&&a==1){
						if (ground[0][1]!=0&&ground[0][0]==1){
							return true;
						}
					}if(b==0&&a==7){
						if (ground[8][1]!=0&&ground[8][0]==1){
							return true;
						}
					}if(b==7&&a==0){
						if (ground[1][8]!=0&&ground[0][8]==1){
							return true;
						}
					}if(b==7&&a==8){
						if (ground[7][8]!=0&&ground[8][8]==1){
							return true;
						}
					}

					if (b==0&&x > 0 && x < 8 && ground[a-c][0] == 1) {
						int s = a-c;
						if (ground[s - 1][0] != 0 && ground[s + 1][0] != 0 && ground[s][1] != 0) {
							return true;
						}
					}
					else if (b==8&&x > 0 && x < 8 && ground[a-c][8] == 1) {
						int s = a-c;
						if (ground[s - 1][8] != 0 && ground[s + 1][8] != 0 && ground[s][7] != 0) {
							return true;
						}
					}
					else if (a==0&&y > 0 && y< 8 && ground[0][b-d] == 1) {
						int s = b-d;
						if (ground[0][s - 1] != 0 && ground[0][s + 1] != 0 && ground[1][s] != 0) {
							return true;
						}
					}
					else if (a==8&&y > 0 && y< 8 && ground[8][b-d] == 1) {
						int s = b-d;
						if (ground[8][s - 1] != 0 && ground[8][s + 1] != 0 && ground[7][s] != 0) {
							return true;
						}
					}

					if(isLegal(a-c,b-d)&&ground[a - c][b - d] == 1) {
						if (isLegal(a - 2 * c, b - 2 * d) && ground[a - 2 * c][b - 2 * d] != 0) {
							if (isLegal(a - c - d, b - d - c) && ground[a - c - d][b - d - c] != 0) {
								if (isLegal(a - c + d, b - d + c) && ground[a - c + d][b - d + c] != 0) {

									return true;
								}
							}


						}
					}
					else return false;
				}
				else return false;

			}
		}
		return true;

	}

	public static boolean isheiwulu(int x,int y){



		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if ((i == 0 && j == 0)||i*j!=0) {

					continue;

				}

				int a = x + i;
				int b = y + j;
				if (isLegal(a, b) && ground[a][b] != 0) {
					int c = i;
					int d = j;
					if(b==0&&a==1){
						if (ground[0][1]!=0&&ground[0][0]==2){
							return true;
						}
					}if(b==0&&a==7){
						if (ground[8][1]!=0&&ground[8][0]==2){
							return true;
						}
					}if(b==7&&a==0){
						if (ground[1][8]!=0&&ground[0][8]==2){
							return true;
						}
					}if(b==7&&a==8){
						if (ground[7][8]!=0&&ground[8][8]==2){
							return true;
						}
					}

					if (b==0&&x > 0 && x < 8 && ground[a-c][0] == 2) {
						int s = a-c;
						if (ground[s - 1][0] != 0 && ground[s + 1][0] != 0 && ground[s][1] != 0) {
							return true;
						}
					}
					else if (b==8&&x > 0 && x < 8 && ground[a-c][8] == 2) {
						int s = a-c;
						if (ground[s - 1][8] != 0 && ground[s + 1][8] != 0 && ground[s][7] != 0) {
							return true;
						}
					}
					else if (a==0&&y > 0 && y< 8 && ground[0][b-d] == 2) {
						int s = b-d;
						if (ground[0][s - 1] != 0 && ground[0][s + 1] != 0 && ground[1][s] != 0) {
							return true;
						}
					}
					else if (a==8&&y > 0 && y< 8 && ground[8][b-d] == 2) {
						int s = b-d;
						if (ground[8][s - 1] != 0 && ground[8][s + 1] != 0 && ground[7][s] != 0) {
							return true;
						}
					}

					if(isLegal(a-c,b-d)&&ground[a - c][b - d] == 2) {
						if (isLegal(a - 2 * c, b - 2 * d) && ground[a - 2 * c][b - 2 * d] != 0) {
							if (isLegal(a - c - d, b - d - c) && ground[a - c - d][b - d - c] != 0) {
								if (isLegal(a - c + d, b - d + c) && ground[a - c + d][b - d + c] != 0) {

									return true;
								}
							}


						}
					}
					else return false;
				}
				else return false;

			}
		}
		return true;

	}



     public static boolean aisbaiwulu(int x,int y){

		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if ((i == 0 && j == 0)||i*j!=0)
					continue;
				int a = x + i;
				int b = y + j;

					int e=x,f=y;

					if (isLegal(a, b) && ground[a][b] == 0) {
						if (ground[x][y] == 1){
						return true;
//						int c = i, d = j;
//
//						if (ground[e+1][f] != 0&&ground[e-1][f] != 0&&ground[e][f+1] != 0&&ground[e][f-1] != 0)
//
//						{
//							return true;
//						}
					}


				}
				else return false;

			}
		}
		return true;

	}

	public static boolean aisheiwulu(int x,int y){

		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if ((i == 0 && j == 0)||i*j!=0)
					continue;
				int a = x + i;
				int b = y + j;

					int e=x,f=y;

					if (isLegal(a, b) && ground[a][b] == 0) {
						if (ground[x][y] == 2){
						return true;
//						int c = i, d = j;
//
//						if (ground[e+1][f] != 0&&ground[e-1][f] != 0&&ground[e][f+1] != 0&&ground[e][f-1] != 0)
//
//						{
//							return true;
//						}
					}


				}
				else return false;

			}
		}
		return true;

	}

	public static boolean ishegan(int x, int y) {

		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				int a = x + i;
				int b = y + j;

				if (isLegal(a, b) && ground[a][b] == 2) {

					if (isLegal(a,b-i)&&isLegal(a-i,b)&& ground[a][b - j] == 2 ) {
						if (ground[a - i][b] == 2) {
							if ((i<=0&&j>=0)||(i>=0&&j>=0)||(i<=0&&j<=0)||(i>=0&&j<=0)) {
								int e=i,f=j;
								if (e==f&&Math.abs(e-f)<=1&&e*f!=0){
									if (ground[x][y] == 2) {
										int m=x,n=y;

										if (e < 0 && f < 0) {
											groundgan[n-1][m-1] = 4;
										}else
										if (e < 0 && f > 0) {
											groundgan[n+1][m] = 4;
										}else
										if (e > 0 && f < 0) {
											groundgan[n][m+1] = 4;
										}else
										if (e > 0 && f> 0) {
											groundgan[n][m] =4;
										}
										return true;
									} else return false;
								}

							} else return false;
						}else break;
					}
					else return false;
				}
				else return false;

			}
		}

		return true;
	}

	public static boolean isbaigan(int x,int y){
		int i,j;
		for (i = -1; i < 2; i++) {
			for (j = -1; j < 2; j++) {
				if (i == 0 && j == 0)
					continue;
				int a = x + i;
				int b = y + j;
				int c = x;
				int d = y;
				if (isLegal(a, b) && ground[a][b] == 1) {

					if (isLegal(a,b-i)&&isLegal(a-i,b)&& ground[a][b - j] == 1 ) {
						if (ground[a - i][b] == 1) {
							if ((i<=0&&j>=0)||(i>=0&&j>=0)||(i<=0&&j<=0)||(i>=0&&j<=0)) {
								int e=i,f=j;
								if (e==f&&Math.abs(e-f)<=1&&e*f!=0){
									if (ground[x][y] == 1
											) {
										int m=x,n=y;

										if (e < 0 && f < 0) {
											groundgan[n-1][m-1] = 3;

										}else
										if (e < 0 && f > 0) {
											groundgan[n-1][m] = 3;
										}else
										if (e > 0 && f < 0) {
											groundgan[n][m-1] = 3;
										}else
										if (e > 0 && f> 0) {
											groundgan[n][m] =3;
										}
										return true;

									}
									else return false;
								}

							} else return false;
						}else break;
					}
					else return false;
				}
				else return false;

			}
		}
		return true;

	}

	public static boolean isLegal(int x, int y) {
		return x >=0 && x < 9 && y >=0&& y < 9;
	}

	public static boolean isHeiFive(int x,int y){
		if (isHVFive(x,y,9)||isHHFive(x,y,9)){
			return true;
		}
		return false;
	}
	public static boolean isBaiFive(int x,int y){
		if (isBVFive(x,y,9)||isBHFive(x,y,9)){
			return true;
		}
		return false;
	}

	// 横向是否五子连珠
	public static boolean isHFive(int x,int y){
		if (isBHFive(x,y,9)||isHHFive(x,y,9)){
			return true;
		}
		return false;
	}
	public static boolean isVFive(int x,int y){
		if (isBVFive(x,y,9)||isHVFive(x,y,9)){
			return true;
		}
		return false;
	}
	public static boolean isBHFive(int x, int y, int mode) {
		int count = 1;
		if (Constant.ground[y][x]==1) {
			for (int i = x; i < 8; i++) {
				if (Constant.ground[y][x] == Constant.ground[y][i + 1]) {
					count++;
				} else {
					break;
				}
			}
			for (int j = x; j > 0; j--) {
				if (Constant.ground[y][x] == Constant.ground[y][j - 1]) {
					count++;
				} else {
					break;
				}
			}
		}
		if (count >= mode) {
			return true;
		}
		return false;
	}
	public static boolean isBVFive(int x,int y,int mode){
		int count = 1;
		if (Constant.ground[y][x]==1) {

			for (int i = y; i <8; i++) {
				if (Constant.ground[y][x] == Constant.ground[i + 1][x]) {
					count++;
				} else {
					break;
				}

			}
			for (int j = y; j > 0; j--) {
				if (Constant.ground[y][x] == Constant.ground[j - 1][x]) {
					count++;
				} else {
					break;
				}
			}
		}
		if (count >= mode) {
			return true;
		}
		return false;

	}


	public static boolean isHHFive(int x,int y,int mode){
		int count = 1;
		if (Constant.ground[y][x]==2) {
			for (int i = x; i < 8; i++) {
				if (Constant.ground[y][x] == Constant.ground[y][i + 1]) {
					count++;
				} else {
					break;
				}
			}
			for (int j = x; j > 0; j--) {
				if (Constant.ground[y][x] == Constant.ground[y][j - 1]) {
					count++;
				} else {
					break;
				}
			}
		}
		if (count >= mode) {
			return true;
		}
		return false;

	}


	// 纵向是否五子连珠
	public static boolean isHVFive(int x, int y, int mode) {
		int count = 1;
		if (Constant.ground[y][x]==2) {

			for (int i = y; i < 8; i++) {
				if (Constant.ground[y][x] == Constant.ground[i + 1][x]) {
					count++;
				} else {
					break;
				}

			}
			for (int j = y; j > 0; j--) {
				if (Constant.ground[y][x] == Constant.ground[j - 1][x]) {
					count++;
				} else {
					break;
				}
			}
		}
		if (count >= mode) {
			return true;
		}
		return false;
	}
	public static int bvf(int x,int y){
		int b=0;
		int bvf = 0;
		for (x = 0; x < 9; x++) {

			if (Utils.isBVFive(x, y, 9)) {
				bvf++;
			}
		}
		return bvf;
	}
	public static int bhf(int x,int y){
		int bhf = 0;
		for (y = 0; y < 9; y++) {
			if (Utils.isBHFive(x, y, 9)) {
				bhf++;
			}
		}
		return bhf;
	}
	public static int hhf(int x,int y){
		int hhf = 0, h = 0;
		for (y = 0; y < 9; y++) {
			if (Utils.isHHFive(x, y, 9)) {
				hhf++;
			}
		}
		return hhf;

	}
	public static int hvf(int x,int y){
		int hvf = 0;
		for (x = 0; x < 9; x++) {
			if (Utils.isHVFive(x, y, 9)) {
				hvf++;
			}
		}
		return hvf;
	}
	public static int bf(int x,int y){
		int bbbf=0;
		return bhf(x,y)+bvf(x,y);
	}
	public static int hf(int x,int y){
		int hhhf=0;
		return hvf(x,y)+hhf(x,y);
	}


	
	public static void initGroup(){
		int length =  Constant.ground.length;
		for (int i = 0; i < length; i++) {
			for(int j = 0;j < length;j++){
				Constant.ground[i][j] = 0;

			}
		}
		
	}

//	public static void initGanGroup(){
//		int length =  groundgan.length;
//		for (int i = 0; i < length; i++) {
//			for(int j = 0;j < length;j++){
////				Constant.ground[i][j] = 0;
//				groundgan[i][j] = groundgan[i][j];
//			}
//		}
//
//	}

}

