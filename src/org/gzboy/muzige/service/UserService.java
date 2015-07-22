package org.gzboy.muzige.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.gzboy.muzige.util.ConnectToDBUtil;
	
/**
 * �����û�������
 * @author BI_GUOZHE
 *
 */
public class UserService {
	/**
	 * �����û���Ϣ
	 * @param requestMap
	 * @return
	 */
	public static boolean UserUpdate(Map<String, String> requestMap){
		boolean result = true;
		String userMsg = requestMap.get("Content");
		String weixin_openid = requestMap.get("FromUserName");
//		String userMsg = "#��Ա��Ϣ:����,��,1990-07-14,18651866595";
		String userName = userMsg.split(":")[1].split(",")[0];
		String userSex = userMsg.split(":")[1].split(",")[1];
		String birthday = userMsg.split(":")[1].split(",")[2];
		String phone_no = userMsg.split(":")[1].split(",")[3];
		//�������ݿ⣬���û���Ϣ���
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.UpdateUserData(weixin_openid,userName,userSex,birthday,phone_no);
		return result;
	}
	/**
	 * �û���ע�˹����˺ţ��ͽ����û���weixin_openid��ӵ����ݿ���
	 * @param requestMap
	 * @return
	 */
	public static boolean UserAdd(Map<String, String> requestMap){
		boolean result = true;
		String weixin_openid = requestMap.get("FromUserName");
		//�������ݿ⣬���û���Ϣ���
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.InsertUserData(weixin_openid);
		return result;
	}
	/**
	 * �û�ȡ����עʱ��ɾ���û���Ϣ
	 * @param requestMap
	 * @return
	 */
	public static boolean UserDel(Map<String, String> requestMap){
		boolean result = true;
		String userMsg = requestMap.get("Content");
		String weixin_openid = requestMap.get("FromUserName");
//		String userMsg = "#��Ա��Ϣ:����,��,1990-07-14,18651866595";
		String userName = userMsg.split(":")[1].split(",")[0];
		String userSex = userMsg.split(":")[1].split(",")[0];
		String birthday = userMsg.split(":")[1].split(",")[0];
		String phone_no = userMsg.split(":")[1].split(",")[0];
		//�������ݿ⣬���û���Ϣ���
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		connectToDBUtil.UpdateUserData(weixin_openid,userName,userSex,birthday,phone_no);
		return result;
	}
	/**
	 * ��ѯ�û���Ϣ
	 * @param requestMap
	 * @return
	 */
	public static String UserSelect(Map<String, String> requestMap){
		StringBuffer buffer = new StringBuffer();
		String weixin_openid = requestMap.get("FromUserName");
		//�������ݿ⣬���û���Ϣ���
		ConnectToDBUtil connectToDBUtil = new ConnectToDBUtil();
		Map userInfoMap = connectToDBUtil.SelectUserData(weixin_openid);
		String userName = (String) userInfoMap.get("userName");
		String sexId = (String) userInfoMap.get("SexId");
		String birthday = (String) userInfoMap.get("birthday");
		String phone_no = (String) userInfoMap.get("phone_no");
		String userSex = null;
		if(sexId.equals("1")){
			userSex = "��";
		}else{
			userSex = "Ů";
		}
		buffer.append("������").append(userName).append("\n");
		buffer.append("�Ա�").append(userSex).append("\n");
		buffer.append("���գ�").append(birthday).append("\n");
		buffer.append("�绰��").append(phone_no).append("\n\n");
		return buffer.toString();
	}
	
	public static void UserBirthday() throws Exception{
	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
    String clidate = "1978-05-22";
    Calendar cToday = Calendar.getInstance(); // �����
    Calendar cBirth = Calendar.getInstance(); // ������
    cBirth.setTime(myFormatter.parse(clidate)); // ��������
    cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // �޸�Ϊ����
    int days; 
    if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
        // �����Ѿ����ˣ�Ҫ���������
        days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
        days += cBirth.get(Calendar.DAY_OF_YEAR);
    } else {
        // ���ջ�û��
        days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
    }
    // ������
    if (days == 0) {
        System.out.println("��������");
    } else {
        System.out.println("�������ջ��У�" + days + "��");
    }
	}
}