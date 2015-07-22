package org.gzboy.muzige.service;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.gzboy.muzige.message.resp.Music;
import org.gzboy.muzige.message.resp.MusicMessage;
import org.gzboy.muzige.util.MessageUtil;

/**
 * 菜单处理类
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
		// 发送方帐号（open_id）
		String fromUserName = requestMap.get("FromUserName");
		// 公众帐号
		String toUserName = requestMap.get("ToUserName");
		// 消息类型
		String msgType = requestMap.get("MsgType");
		return respContent;
	}
	/**
	 * 主菜单
	 * 
	 * @return
	 */
	public static String getMainMenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("您好，请回复数字选择服务：").append("\n\n");
		buffer.append("1  最新商品信息").append("\n");
		buffer.append("2  集赞查询").append("\n");
		buffer.append("3  快递信息").append("\n");
		buffer.append("4  店铺位置").append("\n");
		buffer.append("5  如何添加自己的会员信息").append("\n");
		buffer.append("6  如何集赞").append("\n");
		buffer.append("7  如何翻译").append("\n");
		buffer.append("8  历史上的今天").append("\n");
		buffer.append("9  音乐搜索").append("\n\n");
		buffer.append("回复“?”显示此帮助菜单");
		return buffer.toString();
	}
	/**
	 * 判断是否是QQ表情
	 * 
	 * @param content
	 * @return
	 */
	public static boolean isQqFace(String content) {
		boolean result = false;
		// 判断QQ表情的正则表达式
		String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
		Pattern p = Pattern.compile(qqfaceRegex);
		Matcher m = p.matcher(content);
		if (m.matches()) {
			result = true;
		}
		return result;
	}
	/**
	 * Q译通使用指南
	 * 
	 * @return
	 */
	public static String getTranslateUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Q译通使用指南").append("\n\n");
		buffer.append("Q译通为用户提供专业的多语言翻译服务，目前支持以下翻译方向：").append("\n");
		buffer.append("    中 -> 英").append("\n");
		buffer.append("    英 -> 中").append("\n");
		buffer.append("    日 -> 中").append("\n\n");
		buffer.append("使用示例：").append("\n");
		buffer.append("    翻译我是中国人").append("\n");
		buffer.append("    翻译dream").append("\n");
		buffer.append("    翻译さようなら").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}
	

	/**
	 * 歌曲点播使用指南
	 * 
	 * @return
	 */
	public static String getMusicUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("歌曲点播操作指南").append("\n\n");
		buffer.append("回复：歌曲+歌名").append("\n");
		buffer.append("例如：歌曲存在").append("\n");
		buffer.append("或者：歌曲存在@汪峰").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}
	
	
	

}
