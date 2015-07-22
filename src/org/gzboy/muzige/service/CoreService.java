package org.gzboy.muzige.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.gzboy.muzige.message.resp.TextMessage;
import org.gzboy.muzige.util.MessageUtil;
import org.gzboy.muzige.message.resp.Article;
import org.gzboy.muzige.message.resp.Music;
import org.gzboy.muzige.message.resp.MusicMessage;
import org.gzboy.muzige.message.resp.NewsMessage;

/**
 * ���ķ�����
 * 
 * @author BI_GUOZHE
 * @date 2014-05-20
 */
public class CoreService {
	/**
	 * ����΢�ŷ���������
	 * 
	 * @param request
	 * @return
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// Ĭ�Ϸ��ص��ı���Ϣ����
			String respContent = "�������쳣�����Ժ��ԣ�";

			// xml�������
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// ���ͷ��ʺţ�open_id��
			String fromUserName = requestMap.get("FromUserName");
			// �����ʺ�
			String toUserName = requestMap.get("ToUserName");
			// ��Ϣ����
			String msgType = requestMap.get("MsgType");

			// �ı���Ϣ
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				// ���յ����ı���Ϣ����
				String msgContent = requestMap.get("Content");
				MenuService menuService = new MenuService();
				// �ж��û����͵��Ƿ��ǵ���QQ����
				if (menuService.isQqFace(msgContent)) {
					// �û���ʲôQQ���飬�ͷ���ʲôQQ����
					respContent = msgContent;
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					// �������qq���飬�Д��Ñ��l�͵ă�������Է�����ֿ�ͷ������
				} else if (msgContent.equals("1")) {
					respContent = "������Ʒ���Ż���Ϣ";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("2")) {
					respContent = "���ļ��޸���Ϊ��80��";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("3")) {
					respContent = "������Ӳ�ѯ�����Ϣ��http://m.kuaidi100.com";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("4")) {
					respContent = "�����̵�ַΪ������ʡ�����в��н־���㳡ľ����ľרӪ�ꡣ���˴�����Ӱٶȵ�ͼ���ӣ�";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("5")) {
					respContent = "���������Ϣ���ƺ���Ϊ�Լ�����ϢȻ���͸��Ұ�\n\n#��Ա��Ϣ:�ع���,Ů,1993-05-14,15851866595";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("6")) {
					respContent = "���͡�#���޸������޵ĸ����������ͺ���Ҫ���Ͻ�ͼ�����\n���޷�ʽ��ת������΢�ţ����ߴ������·�ɹ����������Ȧ���޾���Ч��\nʹ�÷�������50���޿ɻ�����Ʒһ�ݻ���9���Żݶ�ѡһ";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("7")) {
					respContent = MenuService.getTranslateUsage();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("8")) {
					respContent = TodayInHistoryService.getTodayInHistoryInfo();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.equals("9")) {
					respContent = MenuService.getMusicUsage();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.startsWith("#��Ա��Ϣ")) {
					if (UserService.UserUpdate(requestMap)) {
						String user_info = UserService.UserSelect(requestMap);
						respContent = "��Ա��Ϣ���³ɹ�,������Ϣ����:\n\n" + user_info
								+ "����д������������������ϵ����Ա";
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				} else if (msgContent.startsWith("#���޸���")) {
					respContent = "�ռ��޳ɹ�";
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if (msgContent.startsWith("����")) {
					String keyWord = msgContent.replaceAll("^����", "").trim();
					if ("".equals(keyWord)) {
						// �ظ��ı���Ϣ
						respContent = MenuService.getTranslateUsage();
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else {
						respContent = BaiduTranslateService.translate(keyWord);
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				} else if (msgContent.startsWith("����")) {
					// ������2���ּ����������+���ո�-���������ȥ��
					String keyWord = msgContent.replaceAll(
							"^����[\\+ ~!@#%^-_=]?", "");
					// �����������Ϊ��
					if ("".equals(keyWord)) {
						respContent = MenuService.getMusicUsage();
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					} else {
						String[] kwArr = keyWord.split("@");
						// ��������
						String musicTitle = kwArr[0];
						// �ݳ���Ĭ��Ϊ��
						String musicAuthor = "";
						if (2 == kwArr.length) {
							musicAuthor = kwArr[1];
						}
						// ��������
						Music music = BaiduMusicService.searchMusic(musicTitle,
								musicAuthor);
						// δ����������
						if (null == music) {
							respContent = "�Բ���û���ҵ��������ĸ���<" + musicTitle + ">��";
							TextMessage textMessage = new TextMessage();
							textMessage.setToUserName(fromUserName);
							textMessage.setFromUserName(toUserName);
							textMessage.setCreateTime(new Date().getTime());
							textMessage
									.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
							textMessage.setFuncFlag(0);
							textMessage.setContent(respContent);
							respMessage = MessageUtil
									.textMessageToXml(textMessage);
						} else {
							// ������Ϣ
							MusicMessage musicMessage = new MusicMessage();
							musicMessage.setToUserName(fromUserName);
							musicMessage.setFromUserName(toUserName);
							musicMessage.setCreateTime(new Date().getTime());
							musicMessage
									.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);
							musicMessage.setMusic(music);
							respMessage = MessageUtil
									.musicMessageToXml(musicMessage);
						}
					}
				} else if (msgContent.equals("10")) {
					// ����ͼ����Ϣ
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setToUserName(fromUserName);
					newsMessage.setFromUserName(toUserName);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setFuncFlag(0);
					List<Article> articleList = new ArrayList<Article>();
					Article article1 = new Article();
					article1.setTitle("�������");
					article1.setDescription("");
					// ��ͼƬ��Ϊ��
					article1.setPicUrl("");
					article1.setUrl("http://gzboyweixin.sinaapp.com");
					Article article2 = new Article();
					article2.setTitle("�����㲥����ָ��\n\n�ظ�������+����\n���磺��������\n���ߣ���������@����");
					article2.setDescription("");
					article2.setPicUrl("http://1.gzboyweixin.sinaapp.com/image/yinyue.jpg");
					article2.setUrl("");
					Article article3 = new Article();
					article3.setTitle("Q��ͨʹ��ָ��\n\nQ��ͨΪ�û��ṩרҵ�Ķ����Է������Ŀǰ֧�����·��뷽��\n    �� -> Ӣ\n    Ӣ -> ��\n    �� -> ��\n\nʹ��ʾ����\n    ���������й���\n    ����dream\n    ���뤵�褦�ʤ�");
					article3.setDescription("");
					article3.setPicUrl("http://1.gzboyweixin.sinaapp.com/image/fanyi.png");
					article3.setUrl("");
					Article article4 = new Article();
					article4.setTitle("���ͣ��鿴���˵�");
					article4.setDescription("");
					article4.setPicUrl("");
					article4.setUrl("http://gzboyweixin.sinaapp.com");
					articleList.add(article1);
					articleList.add(article2);
					articleList.add(article3);
					articleList.add(article4);
					newsMessage.setArticleCount(articleList.size());
					newsMessage.setArticles(articleList);
					respMessage = MessageUtil.newsMessageToXml(newsMessage);
				} else if (msgContent.equals("?") || msgContent.equals("��")) {
					respContent = MenuService.getMainMenu();
					TextMessage textMessage = new TextMessage();
					textMessage.setToUserName(fromUserName);
					textMessage.setFromUserName(toUserName);
					textMessage.setCreateTime(new Date().getTime());
					textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
					textMessage.setFuncFlag(0);
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				// respContent = menuService.MenuRequest(requestMap);
				// ͼƬ��Ϣ
			} else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
				respContent = "�����͵���ͼƬ��Ϣ��";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ����λ����Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
				respContent = "�����͵��ǵ���λ����Ϣ��";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ������Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
				respContent = "�����͵���������Ϣ��";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// ��Ƶ��Ϣ
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
				respContent = "�����͵�����Ƶ��Ϣ��";
				TextMessage textMessage = new TextMessage();
				textMessage.setToUserName(fromUserName);
				textMessage.setFromUserName(toUserName);
				textMessage.setCreateTime(new Date().getTime());
				textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
				textMessage.setFuncFlag(0);
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// �¼�����
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// �¼�����
				String eventType = requestMap.get("Event");
				// ����
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					if (UserService.UserAdd(requestMap)) {
						respContent = "лл���Ĺ�ע��Ϊ�˸��õ�Ϊ�������뾡�����Ƹ�����Ϣ������ͨ�����͡�?�����鿴�˵���ʹ�÷�����";
						TextMessage textMessage = new TextMessage();
						textMessage.setToUserName(fromUserName);
						textMessage.setFromUserName(toUserName);
						textMessage.setCreateTime(new Date().getTime());
						textMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
						textMessage.setFuncFlag(0);
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
				// ȡ������
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
				}
				// �Զ���˵�����¼�
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ
//					String eventKey = requestMap.get("EventKey");
//
//					if (eventKey.equals("11")) {
//						respContent = "����Ԥ���˵�������";
//					} else if (eventKey.equals("12")) {
//						respContent = "������ѯ�˵�������";
//					} else if (eventKey.equals("13")) {
//						respContent = "�ܱ������˵�������";
//					} else if (eventKey.equals("14")) {
//						respContent = "��ʷ�ϵĽ���˵�������";
//					} else if (eventKey.equals("21")) {
//						respContent = "�����㲥�˵�������";
//					} else if (eventKey.equals("22")) {
//						respContent = "������Ϸ�˵�������";
//					} else if (eventKey.equals("23")) {
//						respContent = "��Ů��̨�˵�������";
//					} else if (eventKey.equals("24")) {
//						respContent = "����ʶ��˵�������";
//					} else if (eventKey.equals("25")) {
//						respContent = "������ྲ˵�������";
//					} else if (eventKey.equals("31")) {
//						respContent = "Q��Ȧ�˵�������";
//					} else if (eventKey.equals("32")) {
//						respContent = "��Ӱ���а�˵�������";
//					} else if (eventKey.equals("33")) {
//						respContent = "��ĬЦ���˵�������";
//					}
				}
			}
			// textMessage.setContent(respContent);
			// respMessage = MessageUtil.textMessageToXml(textMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respMessage;
	}
}
