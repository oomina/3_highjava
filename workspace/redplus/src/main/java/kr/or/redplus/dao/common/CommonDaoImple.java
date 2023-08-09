package kr.or.redplus.dao.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import kr.or.redplus.vo.common.BloodCountVO;
import util.MybatisSqlSessionFactory;

public class CommonDaoImple implements ICommonDao {
	private static ICommonDao dao;
	private static SqlSession session;
	
	private CommonDaoImple() {
		
	}
	
	public static ICommonDao getDao() {
		if(dao==null) {dao = new CommonDaoImple();}
		return dao;
	}
	

	@Override
	public BloodCountVO getBloodCount(String date) {
		BloodCountVO vo = null;
		
		//날짜형식 db에 맞게 자동변환
		String[] formats = {"yy-MM-dd", "yyyy/MM/dd", "yyyy-MM-dd", "yy/MM/dd"};
		Date date_ = null;

		for (String format : formats) {
		    try {
		        date_ = new SimpleDateFormat(format).parse(date);
		        break;
		    } catch (ParseException e) {
		        // 날짜 형식이 맞지 않으면 다음 형식을 시도합니다.
		    }
		}

		if (date_ != null) {
		    DateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
		    date = outputFormat.format(date_);
		    String formattedDate = outputFormat.format(date_);
		    System.out.println("이날짜 통계를 불러옵니다"+ formattedDate); // 출력: 2023/04/18
		} else {
		    System.out.println("올바른 날짜 형식이 아닙니다.");
		}
		
				
		try {
		  session = MybatisSqlSessionFactory.getSqlSession();
		  vo = session.selectOne("common.getBloodCount", date);
		} catch (Exception e) {
		  e.printStackTrace();	
		} finally {
		  session.commit();
		  session.close();
		}
		
		return vo;
	}

}
