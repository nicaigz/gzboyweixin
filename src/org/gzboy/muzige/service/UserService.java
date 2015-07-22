package org.gzboy.muzige.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.gzboy.muzige.util.ConnectToDBUtil;
	
/**
 * 处理用户操作类
 * @author BI_GUOZHE
 *
 */
public class UserService {
	/**
	 * 更新用户信息
	 * @param requestMap
	 * @return
	 */
	public static boolean UserUpdate(Map<String, String> requestMap){
		boolean result = true;
		String userMsg = requestMap.get("Content");
		String weixin_openid = requestMap.get("FromUserName");
//		String userMsg = "#会员信息:郭哲,男,1990-07-14,18651866595";
		String userName = userMsg.split(":")[1].split(",")[0];
		String userSex = userMsg.split(":")[1].split(",")[1];
		String birthday = userMsg.split(":")[1].split(",")[2];
		String phone_no = userMsg.split(":")[1].split(",")[3];
		//连接数据库，把用户信息入库
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.UpdateUserData(weixin_openid,userName,userSex,birthday,phone_no);
		return result;
	}
	/**
	 * 用户关注此公众账号，就将该用户的weixin_openid添加到数据库中
	 * @param requestMap
	 * @return
	 */
	public static boolean UserAdd(Map<String, String> requestMap){
		boolean result = true;
		String weixin_openid = requestMap.get("FromUserName");
		//连接数据库，把用户信息入库
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.InsertUserData(weixin_openid);
		return result;
	}
	/**
	 * 用户取消关注时，删除用户信息
	 * @param requestMap
	 * @return
	 */
	public static boolean UserDel(Map<String, String> requestMap){
		boolean result = true;
		String userMsg = requestMap.get("Content");
		String weixin_openid = requestMap.get("FromUserName");
//		String userMsg = "#会员信息:郭哲,男,1990-07-14,18651866595";
		String userName = userMsg.split(":")[1].split(",")[0];
		String userSex = userMsg.split(":")[1].split(",")[0];
		String birthday = userMsg.split(":")[1].split(",")[0];
		String phone_no = userMsg.split(":")[1].split(",")[0];
		//连接数据库，把用户信息入库
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.UpdateUserData(weixin_openid,userName,userSex,birthday,phone_no);
		return result;
	}
	/**
	 * 查询用户信息
	 * @param requestMap
	 * @return
	 */
	public static String UserSelect(Map<String, String> requestMap){
		StringBuffer buffer = new StringBuffer();
		String weixin_openid = requestMap.get("FromUserName");
		//连接数据库，把用户信息入库
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		Map userInfoMap = connectToDBUtil.SelectUserData(weixin_openid);
		String userName = (String) userInfoMap.get("userName");
		String sexId = (String) userInfoMap.get("SexId");
		String birthday = (String) userInfoMap.get("birthday");
		String phone_no = (String) userInfoMap.get("phone_no");
		String userSex = null;
		if(sexId.equals("1")){
			userSex = "男";
		}else{
			userSex = "女";
		}
		buffer.append("姓名：").append(userName).append("\n");
		buffer.append("性别：").append(userSex).append("\n");
		buffer.append("生日：").append(birthday).append("\n");
		buffer.append("电话：").append(phone_no).append("\n\n");
		return buffer.toString();
	}
	
	public static void UserBirthday() throws Exception{
	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
    String clidate = "1978-05-22";
    Calendar cToday = Calendar.getInstance(); // 存今天
    Calendar cBirth = Calendar.getInstance(); // 存生日
    cBirth.setTime(myFormatter.parse(clidate)); // 设置生日
    cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
    int days; 
    if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
        // 生日已经过了，要算明年的了
        days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
        days += cBirth.get(Calendar.DAY_OF_YEAR);
    } else {
        // 生日还没过
        days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
    }
    // 输出结果
    if (days == 0) {
        System.out.println("今天生日");
    } else {
        System.out.println("距离生日还有：" + days + "天");
    }
	}
}