package com.test.demo.web.webSocket.webSocketClient;

import com.test.demo.web.webSocket.webSocketServer.WebSocketConfig;
import com.test.demo.web.webSocket.webSocketServer.WebSocketServer;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/8/18 14:46
 */
@RestController
@RequestMapping(value = "/jc")
public class JavaClientController {

    @Autowired
    private JavaClient javaClient;

    @Autowired
    private WebSocketServer server;

    @GetMapping(value = "/hello")
    public void hello(String str) throws Exception{
        WebSocketClient client = this.javaClient.getClient("ws://10.245.1.52:9069/ws/server/5L25R470016");
        if(client != null){
            client.send(str);
        }
//        String str1 = "{\n" +
//                "\t\"id\": 12,\n" +
//                "\t\"method\": \"personnelData.savePersons\",\n" +
//                "\t\"params\": [{\n" +
//                "\t\t\"Person\": {\n" +
//                "\t\t\t\"Type\": 1,\n" +
//                "\t\t\t\"Code\": \"\",\n" +
//                "\t\t\t\"CredentialNo\": \"\",\n" +
//                "\t\t\t\"GroupNames\": [\"权限组一\"],\n" +
//                "\t\t\t\"Name\": \"张三\",\n" +
//                "\t\t\t\"Sex\": \"male\",\n" +
//                "\t\t\t\"Birthday\": \"1980-01-01\",\n" +
//                "\t\t\t\"AccessTimes\": [{\n" +
//                "\t\t\t\t\"AccessType\": 1,\n" +
//                "\t\t\t\t\"TimeSection\":[1628729708, 1628816108]\n" +
//                "\t\t\t}],\n" +
//                "\t\t\t\"GuestInfo\": {\n" +
//                "\t\t\t\t\"Corp\": \"\",\n" +
//                "\t\t\t\t\"Phone\": \"13800885566\",\n" +
//                "\t\t\t\t\"CarLicense\": \"\",\n" +
//                "\t\t\t\t\"Partner\": 5,\n" +
//                "\t\t\t\t\"Host\": \"李四\",\n" +
//                "\t\t\t\t\"AccessTime\": [{\n" +
//                "\t\t\t\t\t\"from\": 1541756000,\n" +
//                "\t\t\t\t\t\"to\": 1541856000\n" +
//                "\t\t\t\t}]\n" +
//                "\t\t\t},\n" +
//                "\t\t\t\"URL\": [\"http://baidu.com/picture/11.jpg\"],\n" +
//                "\t\t\t\"Feartures\": [\"base64Feartures\"],\n" +
//                "\t\t\t\"Images\": [\"base64Data\"],\n" +
//                "\t\t\t\"Cards\": [{\n" +
//                "\t\t\t\t\"ID\": \"abcd\",\n" +
//                "\t\t\t\t\"Type\": 1,\n" +
//                "\t\t\t\t\"Validity\": [\n" +
//                "\t\t\t\t\t\"2018-10-1\",\n" +
//                "\t\t\t\t\t\"2019-10-1\"\n" +
//                "\t\t\t\t],\n" +
//                "\t\t\t\t\"ValidityTime\": [\n" +
//                "\t\t\t\t\t\"12:30:00\",\n" +
//                "\t\t\t\t\t\"23:59:59\"\n" +
//                "\t\t\t\t],\n" +
//                "\t\t\t\t\"Memo\": {\n" +
//                "\t\t\t\t\t\"Entrance\": \"A座603\"\n" +
//                "\t\t\t\t}\n" +
//                "\t\t\t}]\n" +
//                "\t\t}\n" +
//                "\t}]\n" +
//                "}\n";
//        server.sendMessage(str1);
    }
}
