package listener;

import java.util.EventListener;
import java.util.EventListenerProxy;
import java.util.EventObject;

/**
 * 定义事件源
 * @author node1
 2017年4月6日14:56:11
 */
public class DemoSource {

	//触发DemoEvent 事件
	public void fireEvent(){
		
	}
}

//事件定义
class DemoEvent extends EventObject{
	public DemoEvent(DemoSource source) {
		super(source);
	}
}
//监听器接口定义
class DemoListener extends EventListenerProxy<EventListener>{
	
	public DemoListener(EventListener listener) {
		super(listener);
	}
}
//监听器定义
