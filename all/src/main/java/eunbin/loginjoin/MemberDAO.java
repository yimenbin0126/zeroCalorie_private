package eunbin.loginjoin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원가입 (멤버 추가 메서드)
    public void addMember(MemberVO vo) {
        try {
            Connection con = dataFactory.getConnection();
            int member_no = vo.getMember_no();
            String id = vo.getId();
            String pw = vo.getPw();
            String name = vo.getName();
            String nickname = vo.getNickname();
            String gender = vo.getGender();
            Date birth = vo.getBirth();
            String tel = vo.getTel();
            String email = vo.getEmail();
            int height = vo.getHeight();
            
            String query = "insert into T_member";
            query += "(member_no, id, pw, name, nickname, gender, birth, tel, email, height)";
            query += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println(query);

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, member_no);
            pstmt.setString(2, id);
            pstmt.setString(3, pw);
            pstmt.setString(4, name);
            pstmt.setString(5, nickname);
            pstmt.setString(6, gender);
            pstmt.setDate(7, birth);
            pstmt.setString(8, tel);
            pstmt.setString(9, email);
            pstmt.setInt(10, height);
            
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원가입 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 로그인 메서드
    public int loginMember(String id, String pw) {
    	int count = 0;
        try {
            Connection con = dataFactory.getConnection();
            
            // 쿼리문 작성
            String query = "SELECT count(*) ";
            query += "FROM T_member ";
            query += "WHERE id = '"+id+"' ";
            query += "AND pw = '"+pw+"'";
            System.out.println(query);
            // 쿼리문 저장
            pstmt = con.prepareStatement(query);
            
            // rs의 첫번째 필드값 저장
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
            	count = rs.getInt(1);            	
            }
            rs.close();
            con.close();
            
            System.out.println("로그인 시도");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    // 로그인 완료 시 정보 불러오기
    public MemberVO loginComplet(String _id) {
    	MemberVO  vo = new MemberVO();
        try {
            Connection con = dataFactory.getConnection();
            
            // 쿼리문 작성
            String query = "SELECT member_no, id, pw, name, nickname, gender, birth, tel, email, height ";
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
                
                vo.setMember_no(member_no);
                vo.setId(id);
                vo.setPw(pw);
                vo.setName(name);
                vo.setName(nickname);
                vo.setGender(gender);
                vo.setBirth(birth);
                vo.setTel(tel);
                vo.setEmail(email);
                vo.setHeight(height);
            }
            
            rs.close();
            con.close();
            System.out.println("로그인 정보 불러오기 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
    
    
}