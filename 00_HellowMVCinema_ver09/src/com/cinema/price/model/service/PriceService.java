package com.cinema.price.model.service;
import static com.cinema.common.JDBCTemplate.close;
import static com.cinema.common.JDBCTemplate.commit;
import static com.cinema.common.JDBCTemplate.getConnection;
import static com.cinema.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.cinema.price.model.dao.PriceDAO;
import com.cinema.price.model.vo.Price;
import com.cinema.room.model.dao.RoomDAO;
import com.cinema.room.model.vo.Room;
public class PriceService {
	
	
	public int setPrice(Price price) {
		Connection conn = getConnection();
		int result = new PriceDAO().setPrice(conn, price);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

	public List<Price> getPrice() {
		Connection conn = getConnection();
		List<Price> list = new PriceDAO().getPrice(conn);
		close(conn);
		
		return list;
	}

	public Price getPriceETC(String etc) {
		Connection conn = getConnection();
		Price price = new PriceDAO().getPriceETC(conn, etc);
		close(conn);
		
		return price;
		
	}

	public List<Price> getPriceKind(String kind) {
		Connection conn = getConnection();
		List<Price> list = new PriceDAO().getPriceKind(conn, kind);
		close(conn);
		
		return list;
	}
	

	
	
	
	
}
