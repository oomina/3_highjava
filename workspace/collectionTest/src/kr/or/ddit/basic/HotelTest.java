package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HotelTest {
   Scanner scanner = new Scanner(System.in);
   HashMap<Integer, Room> map = new HashMap<>();
   
   public static void main(String[] args) {
      new HotelTest().hotelStart();
   }
   
   public void hotelStart() {
      System.out.println();
      System.out.println("*********************************************");
      System.out.println("       호텔문을 열었습니다. 어서오십시요.");
      System.out.println("*********************************************");
      System.out.println();
      roomMap();
      
      while(true) {
         System.out.println();
         System.out.println("----------------------------------------------");
         System.out.println("어떤 업무를 하시겠습니까?");
         System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
         System.out.println("----------------------------------------------");
         System.out.print("선택>> ");
         int choice = scanner.nextInt();
         
         switch (choice) {
         case 1 :
            checkIn();
            break;
         case 2 :
            checkOut();
            break;
         case 3 :
            roomCondition();
            break;
         case 4 :
            System.out.println();
            System.out.println("*********************************************");
            System.out.println("       호텔문을 닫았습니다.");
            System.out.println("*********************************************");
            return;
         default:
            System.out.println("번호를 다시 입력해주세요!");
            break;
         }
      }
   }
   
   private void checkIn() {
      System.out.println();
      System.out.println("----------------------------------------------");
      System.out.println("   체크인 작업");
      System.out.println("----------------------------------------------");
      System.out.println(" * 201~209 : 싱글룸");
      System.out.println(" * 301~309 : 더블룸");
      System.out.println(" * 401~409 : 스위트룸");
      System.out.println("----------------------------------------------");
      System.out.print("방 번호 입력 >> ");
      int roomNum = scanner.nextInt();
      Room room = map.get(roomNum);
      
      if(!map.containsKey(roomNum)) {
         System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
      } else if(!room.getName().equals(" - ")) {
         System.out.println(roomNum + "호 객실은 이미 손님이 있습니다.");
      } else {
         System.out.println("누구를 체크인 하시겠습니까?");
         System.out.print("이름 입력 >> ");
         String name = scanner.next();
         map.get(roomNum).setName(name);
         System.out.println("체크인이 완료되었습니다.");
      }
   }
   
   private void checkOut() {
      System.out.println();
      System.out.println("----------------------------------------------");
      System.out.println("   체크아웃 작업");
      System.out.println("----------------------------------------------");
      System.out.println("체크아웃 할 방 번호를 입력하세요.");
      System.out.print("방번호 입력 >> ");
      int roomNum = scanner.nextInt();
      Room room = map.get(roomNum);
      
      if(!map.containsKey(roomNum)) {
         System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
      } else if(room.getName().equals(" - ")) {
         System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
      } else {
         System.out.println(roomNum +"호 객실의 " + room.getName() +"님 체크아웃을 완료하였습니다.");
         map.get(roomNum).setName(" - ");
      }
   }
   
   private void roomCondition() {
      System.out.println("----------------------------------------------");
      System.out.println("      현재 객실 상태");
      System.out.println("----------------------------------------------");
      System.out.println("방 번호   방 종류    투숙객 이름");
      System.out.println("----------------------------------------------");
      List<Integer> list = new ArrayList<>(map.keySet());
      Collections.sort(list);
      for (Integer key : list) {
         Room value = map.get(key);
         System.out.println(value);
      }
      System.out.println("----------------------------------------------");
   }
   
   private void roomMap() {
      for (int i = 201; i <= 209; i++) {
         map.put(i, new Room(i, "싱글룸"));
      }
      for (int i = 301; i <= 309; i++) {
         map.put(i, new Room(i, "더블룸"));
      }
      for (int i = 401; i <= 409; i++) {
         map.put(i, new Room(i, "스위트룸"));
      }
   }
}

class Room {
   private int roomNum;
   private String roomType;
   private String name;
   
   public Room (int roomNum, String roomType) {
      super();
      this.roomNum = roomNum;
      this.roomType = roomType;
      this.name = " - ";
   }

   public int getRoomNum() {
      return roomNum;
   }

   public void setRoomNum(int roomNum) {
      this.roomNum = roomNum;
   }

   public String getRoomType() {
      return roomType;
   }

   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public String toString() {
      return roomNum + "\t" + roomType + "\t " + name;
   }
}