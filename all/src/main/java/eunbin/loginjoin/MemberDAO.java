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
    public void addMember(MemberDTO dto) {
        try {
            Connection con = dataFactory.getConnection();
            int member_no = dto.getMember_no();
            String id = dto.getId();
            String pw = dto.getPw();
            String name = dto.getName();
            String nickname = dto.getNickname();
            String gender = dto.getGender();
            Date birth = dto.getBirth();
            String tel = dto.getTel();
            String email = dto.getEmail();
            int height = dto.getHeight();
            String pro_img = dto.getPro_img();
            
            String query = "insert into T_member";
            query += "(T_MEMBER_SEQUENCE.NEXTVAL, id, pw, name, nickname, gender, birth, tel, email, height, pro_img)";
            query += " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
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
            pstmt.setString(11, pro_img);
            
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
    public MemberDTO loginComplet(String _id) {
    	MemberDTO  dto = new MemberDTO();
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
    
    // 아이디 중복 체크
    public int idCheck(String _id) {
    	int count = 0;
        try {
            Connection con = dataFactory.getConnection();
            
            // 쿼리문 작성
            String query = "SELECT count(*) ";
            query += "FROM T_member ";
            query += "WHERE id = '"+_id+"' ";
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
            
            System.out.println("아이디 중복 체크");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
}