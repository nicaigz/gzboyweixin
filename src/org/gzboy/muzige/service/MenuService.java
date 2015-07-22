package org.gzboy.muzige.service;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.gzboy.muzige.message.resp.Music;
import org.gzboy.muzige.message.resp.MusicMessage;
import org.gzboy.muzige.util.MessageUtil;

/**
 * �˵�������
 * @author BI_GUOZHE
 *
 */
public class MenuService {
		/**
		 * 
		 * @param requestMap
		 * @return
		 */
	public String MenuRequest(Map<String, String> requestMap) {
		// TODO Auto-generated method stub
		String respContent = null;
		// ���ͷ��ʺţ�open_id��
		String fromUserName = requestMap.get("FromUserName");
		// �����ʺ�
		String toUserName = requestMap.get("ToUserName");
		// ��Ϣ����
		String msgType = requestMap.get("MsgType");
		return respContent;
	}
	/**
	 * ���˵�
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("���ã���ظ�����ѡ�����").append("\n\n");
		buffer.append("1  ������Ʒ��Ϣ").append("\n");
		buffer.append("2  ���޲�ѯ").append("\n");
		buffer.append("3  �����Ϣ").append("\n");
		buffer.append("4  ����λ��").append("\n");
		buffer.append("5  �������Լ��Ļ�Ա��Ϣ").append("\n");
		buffer.append("6  ��μ���").append("\n");
		buffer.append("7  ��η���").append("\n");
		buffer.append("8  ��ʷ�ϵĽ���").append("\n");
		buffer.append("9  ��������").append("\n\n");
		buffer.append("�ظ���?����ʾ�˰����˵�");
		return buffer.toString();
	}
	/**
	 * �ж��Ƿ���QQ����
	 * 
	 * @param content
	 * @return
	 */
	public static boolean isQqFace(String content) {
		boolean result = false;
		// �ж�QQ�����������ʽ
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}
	/**
	 * Q��ͨʹ��ָ��
	 * 
	 * @return
	 */
	public static String getTranslateUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Q��ͨʹ��ָ��").append("\n\n");
		buffer.append("Q��ͨΪ�û��ṩרҵ�Ķ����Է������Ŀǰ֧�����·��뷽��").append("\n");
		buffer.append("    �� -> Ӣ").append("\n");
		buffer.append("    Ӣ -> ��").append("\n");
		buffer.append("    �� -> ��").append("\n\n");
		buffer.append("ʹ��ʾ����").append("\n");
		buffer.append("    ���������й���").append("\n");
		buffer.append("    ����dream").append("\n");
		buffer.append("    ���뤵�褦�ʤ�").append("\n\n");
		buffer.append("�ظ���?����ʾ���˵�");
		return buffer.toString();
	}
	

	/**
	 * �����㲥ʹ��ָ��
	 * 
	 * @return
	 */
	public static String getMusicUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("�����㲥����ָ��").append("\n\n");
		buffer.append("�ظ�������+����").append("\n");
		buffer.append("���磺��������").append("\n");
		buffer.append("���ߣ���������@����").append("\n\n");
		buffer.append("�ظ���?����ʾ���˵�");
		return buffer.toString();
	}
	
	
	

}
