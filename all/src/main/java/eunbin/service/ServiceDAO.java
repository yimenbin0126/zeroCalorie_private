package eunbin.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import eunbin.loginjoin.MemberDTO;

public class ServiceDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public ServiceDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 게시물 보여주기
    public ServiceDTO loginComplet(String _id) {
    	ServiceDTO  dto = new ServiceDTO();
        try {
            Connection con = dataFactory.getConnection();
            
            // 쿼리문 작성
            String query = "SELECT * ";
            query += "FROM T_member ";
            query += "WHERE id = '"+_id+"'";
            System.out.println(query);

            // 쿼리문 저장
            pstmt = con.prepareStatement(query);
            
            // 결과값 불러오기
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()) {
            	int member_no = rs.getInt("member_no");
            	String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                String nickname = rs.getString("nickname");
                String gender = rs.getString("gender");
                Date birth = rs.getDate("birth");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                int height = rs.getInt("height");
                String pro_img = rs.getString("pro_img");
                
                dto.setMember_no(member_no);
                dto.setId(id);
                dto.setPw(pw);
                dto.setName(name);
                dto.setName(nickname);
                dto.setGender(gender);
                dto.setBirth(birth);
                dto.setTel(tel);
                dto.setEmail(email);
                dto.setHeight(height);
                dto.setPro_img(pro_img);
            }
            
            rs.close();
            con.close();
            System.out.println("로그인 정보 불러오기 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }
}