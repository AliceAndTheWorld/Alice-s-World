package com.aliceandtheworld.alicesworld.plugin;

import com.mikuac.shiro.common.utils.MsgUtils;
import com.mikuac.shiro.core.Bot;
import com.mikuac.shiro.core.BotPlugin;
import com.mikuac.shiro.dto.event.message.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

//这个类要有 @Component 还有 extends BotPlugin
//前面不加上@Component的话这个类不会被注入运行
//不加上extends BotPlugin的话这个类不会被认为是机器人插件
@Component
public class GangBanPlugin extends BotPlugin {

	//消息的构造对象，每个要发送消息的类都建议在类里面加上这个对象
	MsgUtils sendMsg;

	//onGroupMessage这个方法是每次收到群聊消息就调用一次
	//类似的还有 当有人被踢出 当收到私聊消息 当有人撤回消息
	//具体的事件在这里:
	//https://misakatat.github.io/shiro-docs/override_event/
	@Override
	public int onGroupMessage(@NotNull Bot bot, @NotNull GroupMessageEvent event) {

		//这个event.getRawMessage()就是收到的群聊消息的具体内容
		String messageRaw = event.getRawMessage();

		//if(刚刚收到的消息是"钢板"){那就--------}
		if ("钢板".equals(messageRaw)){

			//sendMsg构造成MsgUtils.builder(),后面跟上多个就可以组合消息
			//具体例子:  MsgUtils.builder().text("123").at(3047354896).img("XXXXX")  就是发送: "123@catand"然后再带上一张图片
		    sendMsg = MsgUtils.builder().tts("好耶我是");
			bot.sendGroupMsg(event.getGroupId(), sendMsg.build(), false);

		}
		//return的如果是MESSAGE_IGNORE,就继续下一个插件
		//return的如果是MESSAGE_BLOCK,就终止运行下一个插件
		//比如我给白咕咕发送"美图涩涩贴贴片片"
		//如果是BLOCK,白咕咕就只检测第一个
		//如果是IGNORE,那白咕咕会把这些都执行一次
		return MESSAGE_IGNORE;
	}
}
