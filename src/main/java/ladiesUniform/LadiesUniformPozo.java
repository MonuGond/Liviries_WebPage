package ladiesUniform;

import java.util.Date;

public class LadiesUniformPozo {
	private int bookno,pgno,g_u_size,empno;
	private String ename,designation;
	private Date gdate;
	String serialno;
	private int s_saree_pcs,c_saree_pcs,syn_saree_pcs,pullover,h_s_cardigan,cardigan_pcs,scarves_pcs,f_p_over;
	
	private double silk_saree_qtn,crape_saree_qtn,synthetic_saree_qtn;
	private double total_p_o_qtny,total_h_s_g_c_qtny,total_l_c_qtny,scarves_qtn,total_f_p_o_qtny;
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public int getPgno() {
		return pgno;
	}
	public void setPgno(int pgno) {
		this.pgno = pgno;
	}
	public int getG_u_size() {
		return g_u_size;
	}
	public void setG_u_size(int g_u_size) {
		this.g_u_size = g_u_size;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public int getS_saree_pcs() {
		return s_saree_pcs;
	}
	public void setS_saree_pcs(int s_saree_pcs) {
		this.s_saree_pcs = s_saree_pcs;
	}
	public int getC_saree_pcs() {
		return c_saree_pcs;
	}
	public void setC_saree_pcs(int c_saree_pcs) {
		this.c_saree_pcs = c_saree_pcs;
	}
	public int getSyn_saree_pcs() {
		return syn_saree_pcs;
	}
	public void setSyn_saree_pcs(int syn_saree_pcs) {
		this.syn_saree_pcs = syn_saree_pcs;
	}
	public int getPullover() {
		return pullover;
	}
	public void setPullover(int pullover) {
		this.pullover = pullover;
	}
	public int getH_s_cardigan() {
		return h_s_cardigan;
	}
	public void setH_s_cardigan(int h_s_cardigan) {
		this.h_s_cardigan = h_s_cardigan;
	}
	public int getCardigan_pcs() {
		return cardigan_pcs;
	}
	public void setCardigan_pcs(int cardigan_pcs) {
		this.cardigan_pcs = cardigan_pcs;
	}
	public int getScarves_pcs() {
		return scarves_pcs;
	}
	public void setScarves_pcs(int scarves_pcs) {
		this.scarves_pcs = scarves_pcs;
	}
	public int getF_p_over() {
		return f_p_over;
	}
	public void setF_p_over(int f_p_over) {
		this.f_p_over = f_p_over;
	}
	public double getSilk_saree_qtn() {
		return silk_saree_qtn;
	}
	public void setSilk_saree_qtn(double silk_saree_qtn) {
		this.silk_saree_qtn = silk_saree_qtn;
	}
	public double getCrape_saree_qtn() {
		return crape_saree_qtn;
	}
	public void setCrape_saree_qtn(double crape_saree_qtn) {
		this.crape_saree_qtn = crape_saree_qtn;
	}
	public double getSynthetic_saree_qtn() {
		return synthetic_saree_qtn;
	}
	public void setSynthetic_saree_qtn(double synthetic_saree_qtn) {
		this.synthetic_saree_qtn = synthetic_saree_qtn;
	}
	public double getTotal_p_o_qtny() {
		return total_p_o_qtny;
	}
	public void setTotal_p_o_qtny(double total_p_o_qtny) {
		this.total_p_o_qtny = total_p_o_qtny;
	}
	public double getTotal_h_s_g_c_qtny() {
		return total_h_s_g_c_qtny;
	}
	public void setTotal_h_s_g_c_qtny(double total_h_s_g_c_qtny) {
		this.total_h_s_g_c_qtny = total_h_s_g_c_qtny;
	}
	public double getTotal_l_c_qtny() {
		return total_l_c_qtny;
	}
	public void setTotal_l_c_qtny(double total_l_c_qtny) {
		this.total_l_c_qtny = total_l_c_qtny;
	}
	public double getScarves_qtn() {
		return scarves_qtn;
	}
	public void setScarves_qtn(double scarves_qtn) {
		this.scarves_qtn = scarves_qtn;
	}
	public double getTotal_f_p_o_qtny() {
		return total_f_p_o_qtny;
	}
	public void setTotal_f_p_o_qtny(double total_f_p_o_qtny) {
		this.total_f_p_o_qtny = total_f_p_o_qtny;
	}
	public LadiesUniformPozo(int bookno, int pgno, int g_u_size, int empno, String ename, String designation,
			Date gdate, String serialno, int s_saree_pcs, int c_saree_pcs, int syn_saree_pcs, int pullover,
			int h_s_cardigan, int cardigan_pcs, int scarves_pcs, int f_p_over, double silk_saree_qtn,
			double crape_saree_qtn, double synthetic_saree_qtn, double total_p_o_qtny, double total_h_s_g_c_qtny,
			double total_l_c_qtny, double scarves_qtn, double total_f_p_o_qtny) {
		super();
		this.bookno = bookno;
		this.pgno = pgno;
		this.g_u_size = g_u_size;
		this.empno = empno;
		this.ename = ename;
		this.designation = designation;
		this.gdate = gdate;
		this.serialno = serialno;
		this.s_saree_pcs = s_saree_pcs;
		this.c_saree_pcs = c_saree_pcs;
		this.syn_saree_pcs = syn_saree_pcs;
		this.pullover = pullover;
		this.h_s_cardigan = h_s_cardigan;
		this.cardigan_pcs = cardigan_pcs;
		this.scarves_pcs = scarves_pcs;
		this.f_p_over = f_p_over;
		this.silk_saree_qtn = silk_saree_qtn;
		this.crape_saree_qtn = crape_saree_qtn;
		this.synthetic_saree_qtn = synthetic_saree_qtn;
		this.total_p_o_qtny = total_p_o_qtny;
		this.total_h_s_g_c_qtny = total_h_s_g_c_qtny;
		this.total_l_c_qtny = total_l_c_qtny;
		this.scarves_qtn = scarves_qtn;
		this.total_f_p_o_qtny = total_f_p_o_qtny;
	}
	public LadiesUniformPozo() {
		super();
	}

}
