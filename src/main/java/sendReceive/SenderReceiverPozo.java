package sendReceive;

public class SenderReceiverPozo {
	private String f_sender,t_receiver;

	public String getF_sender() {
		return f_sender;
	}

	public void setF_sender(String f_sender) {
		this.f_sender = f_sender;
	}

	public String getT_receiver() {
		return t_receiver;
	}

	public void setT_receiver(String t_receiver) {
		this.t_receiver = t_receiver;
	}

	public SenderReceiverPozo(String f_sender, String t_receiver) {
		super();
		this.f_sender = f_sender;
		this.t_receiver = t_receiver;
	}

	public SenderReceiverPozo() {
		super();
	}

}
