package com.yla.queue;

import com.yla.model.YLAFile;
import javax.jms.Message;
//import org.apache.activemq.command.ActiveMQTextMessage;
import com.yla.utils.Execffmpeg;
import org.slf4j.LoggerFactory;
//import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * Created by Yusuf on 03/12/2016.
 */
@Service
public class JmsMessageListener  implements MessageListener {

    private static org.slf4j.Logger slogger = LoggerFactory.getLogger(JmsMessageListener.class);


    public void onMessage(Message message)  {
        // This is the received message
        slogger.info("Logger Name: "+slogger.getName() + " method: onMessage  " +message.toString());


        // Let's prepare a reply message - a "ACK" String
       // ActiveMQTextMessage message = new ActiveMQTextMessage();
        //message.setText("ACK");
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            YLAFile fileObject = null;
            try {
                fileObject = (YLAFile)objectMessage.getObject();
                if (fileObject!= null) {
                    Execffmpeg.convert(fileObject);
                    slogger.debug(fileObject.getFileName());
                    slogger.debug(fileObject.getFileType());
                    slogger.debug(fileObject.getFileDestinationType());
                    slogger.debug(fileObject.getUploadDirectory());
                    slogger.debug(fileObject.getConvertDirectory());
                }
            } catch (JMSException e) {
                slogger.error(e.toString());
            }

            //TODO
            //call file conversion process

        }


        // Message send back to the replyTo address of the income message.
        // Like replying an email somehow.
        //MessageProducer producer = session.createProducer(message.getJMSReplyTo());
        //producer.send(message);
    }


}
