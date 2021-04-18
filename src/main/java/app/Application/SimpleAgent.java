//package app.Application;
//
//import app.Application.Services.Schedule;
//import com.sun.jdmk.comm.HtmlAdaptorServer;
//import org.springframework.stereotype.Service;
//
//
//import javax.management.MBeanServer;
//import javax.management.ObjectName;
//import java.lang.management.ManagementFactory;
//
//@Service
//public class SimpleAgent
//{
//    private MBeanServer mbs = null;
//
//
//    public SimpleAgent()
//    {
//        // Получить экземпляр MBeanServer
//        mbs = ManagementFactory.getPlatformMBeanServer();
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
//        // Создаем наш MBean
//        Schedule scheduleMBean = new Schedule();
//        ObjectName adapterName = null;
//        ObjectName scheduleName = null;
//
//        try {
//            // И регистрируем его на платформе MBeanServer
//            scheduleName = new ObjectName("SimpleAgent:name=Dotask");
//            mbs.registerMBean(scheduleMBean, scheduleName);
//
//            adapterName = new ObjectName("SimpleAgent:name=htmladapter1,port=8082");
//            adapter.setPort(8082);
//            mbs.registerMBean(adapter, adapterName);
//            adapter.start();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
