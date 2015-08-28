package sist.thinking;

import java.util.*;

public class q {
	 static final int size = 5;
	 private int count = 0;
	 private int data = 0;
	 private int side = 0;
	 private int toside = 0;
	 private boolean flag = true;
	 private boolean flag2 = true;
	 private int[] play = new int[size*size];
	 private int cnt = 1;
	 
	 // 1~25까지 랜덤함수를 생성
	 public int random(){
	  Random rr = new Random();
	  int ran = rr.nextInt(25)+1;
	  return ran;
	 }
	 
	 // 1~25까지 숫자 배열을 저장
	 public int[] array(int [] arr){
	  for (int i = 0; i < arr.length;) {
	   int temp = random();
	   boolean flag = true;
	   for (int j = 0; j < i; j++) {
	    if(temp == arr[j]){
	     flag = false;
	    }
	   }
	   if(flag){
	    arr[i] = temp;
	    i++;
	   }
	  }
	  return arr;
	 }
	 
	 // 2차원 배열을 출력
	 public void disp2D(int[][] arr){
	  System.out.println("*──────────────*");
	  for (int i = 0; i < arr.length; i++) {
	   for (int j = 0; j < arr[i].length; j++) {
	    System.out.printf("%3d", arr[i][j]);
	   }
	   System.out.println();
	  }
	  System.out.println("*──────────────*");
	 }
	 
	 // 2차원배열 빙고판 생성
	 public int[][] makeBingo(int[][] bingo, int[]arr){
	  for (int i = 0; i < size; i++) {
	   for (int j = 0; j < size; j++) {
	    bingo[i][j] = arr[count];
	    count++;
	    if(count>size*size-1)
	     break;
	   }
	  }
	  return bingo;
	 }
	 
	 // 빙고체크 초기화
	 public char[][] setBingo(char[][] check){
	  for (int i = 0; i < size; i++) {
	   for (int j = 0; j < size; j++) {
	    check[i][j] = 'x';
	   }
	  }
	  return check;
	 }
	 
	 //
	 public void checkBingo(int[][] bingo, char[][]check){
	  count = 0;
	  for (int i = 0; i < size; i++) {
	   for (int j = 0; j < size; j++) {
	    count++;
	    System.out.println(count+"번째 입니다.");
	    int num = initNum();
	    initO(num, check, bingo);
	    checkBing(check);
	    if(data >= 4) // 빙고 개수에 따른 종료
	     printEnd();
	   }
	  }
	 }
	 
	 public char[][] initO(int num, char[][]check, int[][]bingo){
	  for (int i = 0; i < size; i++) {
	   for (int j = 0; j < size; j++) {
	    if(num == bingo[i][j]){
	     check[i][j] = 'o';
	     lineCheck(i, j, check);
	    }
	   }
	  }
	  return check;
	 }
	 
	 public int qqqq(int arg) {
		 arg++;
		 
	     if(arg==5){
	      data++;
	      System.out.println();
	      System.out.println("["+data+"] 빙고~◇");
	      System.out.println();     
	     }	
	    
	     return arg;	     
	 }
	 
	 // 가로, 세로, 대각선 빙고찾기!
	 public void lineCheck(int i, int j, char[][] check){
	  int x = 0, y = 0, z = 0, k = 0;
	  int rtn = 0;
	  
	  for (int j2 = 0; j2 < 5; j2++) {
	   if(check[i][j2] == 'o'){
		   /*
	    x++;
	    if(x==5){
	     data++;
	     x=0;
	     System.out.println();
	     System.out.println("["+data+"] 빙고~★");
	     System.out.println();
	    }
	    */
		   rtn = qqqq(x);
		   if(rtn == 5) {
			   x = 0;
		   } else {
			   x = rtn;
		   }
	   }
	   
	   if(check[j2][j] == 'o'){
		   /*
	    y++;
	    if(y==5){
	     data++;
	     y=0;
	     System.out.println();
	     System.out.println("["+data+"] 빙고~☆");
	     System.out.println();
	    }
	    */
		   rtn = qqqq(y);
		   if(rtn == 5) {
			   y = 0;
		   } else {
			   y = rtn;
		   }
		   
	   }
	   
	   if(flag){
	    if(check[j2][j2] == 'o'){
	    	/*
	     z++;
	     if(z==5){
	      data++;
	      System.out.println();
	      System.out.println("["+data+"] 빙고~◇");
	      System.out.println();
	      flag = false;
	     
	    	
	     }
	     */ 
	    	rtn = qqqq(z);
	    	if(rtn == 5) {
	    		flag = false;
	    	} else {
	    		z = rtn;
	    	}
	    }
	   }
	   if(flag2){
	    if(check[j2][size-j2-1] == 'o'){
	    	/*
	     k++;
	     if(k==5){
	      data++;
	      System.out.println();
	      System.out.println("["+data+"] 빙고~◆");
	      System.out.println();
	      flag2 = false;
	     
	    	
	     }
	      */
	    	rtn = qqqq(k); 
	    	if(rtn == 5) {
	    		flag2 = false;
	    	} else {
	    		k = rtn;
	    	}
	    }
	   }
	  }
	 }
	 // 빙고줄 확인
	 public void checkBing(char[][] check){
	  System.out.println("*──────────────*");
	  for (int i = 0; i < check.length; i++) {
	   for (int j = 0; j < check.length; j++) {
	    System.out.print(check[i][j]);
	   }
	   System.out.println();
	  }
	  System.out.println("*──────────────*");
	  System.out.println("빙고는 "+ data+"줄 입니다.");
	 }
	 // 숫자기입란
	 public int initNum(){
	  Scanner sc = new Scanner(System.in);
	  System.out.print("1~25사이의 숫자를 입력: ");
	  int init = sc.nextInt();
	  System.out.println("☆☆ 입력한 숫자 = <"+ init +"> =");
	  if(init < 0 || init > 25){
	   error();
	   System.out.println("1~25 사이의 숫자만 입력해주세요!");
	   initNum();
	  }
	  numCheck(init);
	  sc.close();
	  return init;
	 }
	 // 중복기입 숫자 구
	 public void numCheck(int num){
	  for (int i = 0; i < cnt; i++) {
	   if(play[i]!=num){
	    play[i] = num;
	    cnt++;
	    break;
	   }
	   else{
	    error();
	    System.out.println(num+"은 이미 입력한 숫자입니다.");
	    System.out.println();
	    break;
	   }
	  }
	 }
	 // 엔딩
	 public void printEnd(){
	  System.out.println();
	  System.out.println("수고하셨습니다!");
	  System.out.println("   빙고 게임을 종료합니다 ^-^");
	  System.exit(0);
	 }
	 // 에러코드
	 public void error(){
	  System.out.println();
	  System.out.println("       Error!");
	 }
	 // 메인파트
	 public static void main(String[] args) {
	  q bi = new q();
	  int[] length = new int[size*size];
	  int[][] bingo = new int[size][size];
	  int[][] player = new int[size][size];
	  char[][] check = new char[size][size];
	   
	  bi.setBingo(check);
	  bi.array(length);
	  bi.makeBingo(bingo, length);
	  bi.disp2D(bingo);
	  bi.checkBingo(bingo, check);
	  
	 }
	}
