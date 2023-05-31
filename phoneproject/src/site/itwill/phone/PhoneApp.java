package site.itwill.phone;


import java.awt.Container;


import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import site.itwill.dao.PhoneDAO;
import site.itwill.dto.PhoneDTO;





public class PhoneApp extends JFrame {
	//ÇÊµå ÃÊ±âÈ­ true »óÅÂ
	public void fieldinit() {
		Modelfield.setEnabled(true);
		Phonefield.setEnabled(true);
		stockfield.setEnabled(true);
		Huefield.setEnabled(true);
		Memoryfield.setEnabled(true);	
	}
	//ÇÊµå ÃÊ±âÈ­ false »óÅÂ
	public void fieldinitf() {
		Modelfield.setEnabled(false);
		Phonefield.setEnabled(false);
		stockfield.setEnabled(false);
		Huefield.setEnabled(false);
		Memoryfield.setEnabled(false);	
	}
					
	//¹öÆ° ÃÊ±âÈ­ true »óÅÂ
	public void Buttoninit() {
		SELECTALL.setEnabled(true);
		SELECT.setEnabled(true);
		ADD.setEnabled(true);
		UPDATE.setEnabled(true);
		DELETE.setEnabled(true);	
	}
	//¹öÆ° ÃÊ±âÈ­ false »óÅÂ
	public void Buttoninitf() {
		SELECTALL.setEnabled(false);
		SELECT.setEnabled(false);
		ADD.setEnabled(false);
		UPDATE.setEnabled(false);
		DELETE.setEnabled(false);	
	}
	//ÇÊµå ÃÊ±âÈ­ °ø¹é »óÅÂ
	public void fieldclear() {
		Modelfield.setText("");
		Phonefield.setText("");
		Huefield.setText("");
		Memoryfield.setText("");
		stockfield.setText("");
	}
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();
	
	JLabel label1 = new JLabel("Åë½Å»ç");
	JLabel label2 = new JLabel("Á¦Á¶»ç");
	JLabel label3 = new JLabel("±âÁ¾");
	JLabel label4 = new JLabel("»ö±ò");
	JLabel label5 = new JLabel("¿ë·®");
		
	private static final long serialVersionUID = 1L;

	//¹öÆ° Ãß°¡
	JButton SELECT = new JButton("\uAC80\uC0C9");
	JButton RegButton;
	JButton UPDATE = new JButton("¼öÁ¤");
	JButton DELETE = new JButton("»èÁ¦");
	JButton ADD;
	
	JButton CANCEL = new JButton("\uCDE8\uC18C");
	JScrollPane scp;
	JScrollPane scp2;
	FileDialog fd;
	
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	
	private JTable table;
	private JTable table2;
	private JTextField Modelfield;
	private JTextField Phonefield;
	private JTextField Huefield;
	private JTextField Memoryfield;
	private JTextField stockfield;
	private final JLabel Phone = new JLabel("\uAE30\uC885");
	private final JLabel Hue = new JLabel("\uC0C9\uAE54");
	private final JLabel Memory = new JLabel("\uC6A9\uB7C9");
	private final JLabel Stock = new JLabel("\uC7AC\uACE0");
	private final JButton SELECTALL = new JButton("\uC804\uCCB4 \uAC80\uC0C9");
	
	int cmd = 0;
	
	
	public PhoneApp(String title) {
	super(title);
	getContentPane().setBackground(new Color(255, 153, 102));
	label.setBounds(0, 12, 782, 24);
	
	label.setText("ÈÞ´ëÆù Àç°í°ü¸® ÇÁ·Î±×·¥");
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setFont(new Font("±¼¸²", Font.BOLD, 20));
	
	SELECT.setBounds(129, 12, 89, 39);
	
	
	UPDATE.setBounds(220, 12, 101, 39);
	
	CANCEL.setBounds(585, 12, 127, 39);

	DELETE.setBounds(453, 12, 127, 39);
	ADD = new JButton("\uCD94\uAC00");
	ADD.setBounds(324, 12, 127, 39);
	panel.add(ADD);
	SELECTALL.setBounds(14, 12, 111, 39);
	
	panel.setBackground(SystemColor.activeCaption);
	panel.setBounds(0, 680, 782, 73);
	panel.setLayout(null);
	
	
	panel.add(SELECT);
	panel.add(UPDATE);
	panel.add(DELETE);
	panel.add(CANCEL);
	
	
	CANCEL.addActionListener(new ButtonEventHandler());
	SELECT.addActionListener(new ButtonEventHandler());
	SELECTALL.addActionListener(new ButtonEventHandler());
	
	ADD.addActionListener(new ButtonEventHandler());
	UPDATE.addActionListener(new ButtonEventHandler());
	DELETE.addActionListener(new ButtonEventHandler());
	
	Container container = getContentPane();
	getContentPane().setLayout(null);
	
	container.add(label);
	container.add(panel);
	
	
	panel.add(SELECTALL);
	
	Modelfield = new JTextField();
	Modelfield.setFont(new Font("±¼¸²", Font.PLAIN, 22));
	Modelfield.setBounds(257, 78, 360, 35);
	
	getContentPane().add(Modelfield);
	Modelfield.setColumns(10);
	
	Phonefield = new JTextField();
	Phonefield.setFont(new Font("±¼¸²", Font.PLAIN, 22));
	Phonefield.setColumns(10);
	Phonefield.setBounds(257, 138, 360, 35);
	getContentPane().add(Phonefield);
	
	Huefield = new JTextField();
	Huefield.setFont(new Font("±¼¸²", Font.PLAIN, 22));
	Huefield.setColumns(10);
	Huefield.setBounds(257, 198, 360, 35);
	getContentPane().add(Huefield);
	
	Memoryfield = new JTextField();
	Memoryfield.setFont(new Font("±¼¸²", Font.PLAIN, 22));
	Memoryfield.setColumns(10);
	Memoryfield.setBounds(257, 258, 360, 35);
	getContentPane().add(Memoryfield);
	
	stockfield = new JTextField();
	stockfield.setFont(new Font("±¼¸²", Font.PLAIN, 22));
	stockfield.setColumns(10);
	stockfield.setBounds(257, 318, 360, 35);
	getContentPane().add(stockfield);
	
	
	
	JLabel Mdnm = new JLabel("\uBAA8\uB378\uBA85");
	Mdnm.setOpaque(true);

	Mdnm.setBackground(Color.PINK);
	Mdnm.setForeground(Color.BLACK);
	Mdnm.setHorizontalAlignment(SwingConstants.CENTER);
	Mdnm.setBounds(192, 82, 58, 27);
	getContentPane().add(Mdnm);
	Phone.setOpaque(true);
	Phone.setHorizontalAlignment(SwingConstants.CENTER);
	Phone.setForeground(Color.BLACK);
	Phone.setBackground(Color.PINK);
	Phone.setBounds(192, 142, 58, 27);
	
	getContentPane().add(Phone);
	Hue.setOpaque(true);
	Hue.setHorizontalAlignment(SwingConstants.CENTER);
	Hue.setForeground(Color.BLACK);
	Hue.setBackground(Color.PINK);
	Hue.setBounds(192, 202, 58, 27);
	
	getContentPane().add(Hue);
	Memory.setOpaque(true);
	Memory.setHorizontalAlignment(SwingConstants.CENTER);
	Memory.setForeground(Color.BLACK);
	Memory.setBackground(Color.PINK);
	Memory.setBounds(192, 262, 58, 27);
	
	getContentPane().add(Memory);
	Stock.setOpaque(true);
	Stock.setHorizontalAlignment(SwingConstants.CENTER);
	Stock.setForeground(Color.BLACK);
	Stock.setBackground(Color.PINK);
	Stock.setBounds(192, 322, 58, 27);
	
	getContentPane().add(Stock);
	
	//Å×ÀÌºí »ý¼º
	Object [] columnName = {"¸ðµ¨¹øÈ£","±âÁ¾","»ö±ò","¿ë·®(GB)","Àç°í"};
	Object [] columnName2 = {"±âÁ¾","Àç°í ÇÕ"};
	
	table = new JTable(new DefaultTableModel(columnName, 0));
	table2 = new JTable(new DefaultTableModel(columnName2, 0));
	 
	table.setEnabled(false);
	table.getTableHeader().setReorderingAllowed(false);
	table.getTableHeader().setResizingAllowed(false);
	
	table2.setEnabled(false);
	table2.getTableHeader().setReorderingAllowed(false);
	table2.getTableHeader().setResizingAllowed(false);
	scp = new JScrollPane(table);
	scp2 = new JScrollPane(table2);
	
	scp.setBounds(134, 384, 552, 263);
	scp2.setBounds(712, 184, 268, 362);
	getContentPane().add(scp);
	getContentPane().add(scp2);
	

	SelectPhnameStockavg();
	selectAllPhone();
	Modelfield.setEnabled(false);
	Phonefield.setEnabled(false);
	stockfield.setEnabled(false);
	Huefield.setEnabled(false);
	Memoryfield.setEnabled(false);	
	
	/*RegButton = new JButton("\uAC12 \uC785\uB825 \uADDC\uCE59");
	RegButton.setBounds(657, 32, 113, 107);
	getContentPane().add(RegButton);
	RegButton.addActionListener(new ButtonEventHandler());
	*/
	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setBounds(300, 15, 1100, 1100);
	setVisible(true);
}
	public static void main(String[] args) {
		new PhoneApp("ÈÞ´ëÆù Àç°í°ü¸® ÇÁ·Î±×·¥");	
	}
	
	
	public class ButtonEventHandler implements ActionListener{
		
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
		
			Object eventSource = e.getSource();
			
			if ((JButton)eventSource == CANCEL) {
				fieldclear();
				Buttoninit();
				fieldinitf();
				selectAllPhone();
				//ÃÊ±â »óÅÂ
				cmd = 0;
			}
			else if((JButton)eventSource == SELECTALL) {
				selectAllPhone();
				
			
			}
			else if((JButton)eventSource == SELECT) {
				//1Àº select »óÅÂ
			if(cmd != 1) {	
				Buttoninitf();
				selectAllPhone();
				Phonefield.setEnabled(true);
				SELECT.setEnabled(true);
				cmd = 1;
			}
			
			else {
				selectPhone();
		}
			
			}
			else if((JButton)eventSource == UPDATE) {
				//2´Â ¿Ã¹Ù¸¥ °ªÀ» ÀÔ·ÂÇÏ±â Àü »óÅÂ
				if(cmd != 2 && cmd != 5)
				{
					selectAllPhone();
					fieldinitf();
					Modelfield.setEnabled(true);
					Buttoninitf();
					UPDATE.setEnabled(true);
					cmd =2;	
				//5´Â °ªÀ» ¼öÁ¤ÇÏ·Á´Â »óÅÂ
				}else if(cmd != 5) {
					
					fieldinit();
					searchmdnmPhone();
					cmd = 5;
				}else {
					updateStock();
					SelectPhnameStockavg();
					selectAllPhone();
				}
				
			}
			else if((JButton)eventSource == ADD) {
			//3Àº °ªÀ» Ãß°¡ÇÏ·Á´Â »óÅÂ
			if(cmd != 3)
			{
			selectAllPhone();
			fieldinit();
			Buttoninitf();
			ADD.setEnabled(true);
			cmd =3;
			}
			else {
				addPhone();
				SelectPhnameStockavg();
				selectAllPhone();
			}
				
				
			}
			else if((JButton)eventSource == DELETE) {
			//4´Â °ªÀ» Ãß°¡ÇÏ·Á´Â »óÅÂ
				if(cmd != 4) {
					selectAllPhone();
					fieldinitf();
					Modelfield.setEnabled(true);
					Buttoninitf();
					DELETE.setEnabled(true);
					cmd = 4;
				}else {
					deletePhone();
					SelectPhnameStockavg();
					selectAllPhone();
				}
			}	else if((JButton)eventSource == RegButton) {
				JFrame f2 = new JFrame("¡Ø°ª ÀÔ·Â ±ÔÄ¢¡Ø");
				JTextArea area = new JTextArea("¸ðµ¨¹øÈ£ : IP + 1~2ÀÚ¸® ¼ýÀÚ ¶Ç´Â ¹®ÀÚ + ¿ë·®\n±âÁ¾ : ¾ÆÀÌÆù + ¼ýÀÚ + (PLUS)"
						+ "(PRO) + (MAX)\n(¸¸¾à ±âÁ¾ÀÌ PLUSÀÌ°Å³ª PROÀÌ°Å³ª PRO MAX ÀÌ¸é)"
						+ "\n»ö±ò:ÇÑ±Û·Î\n¿ë·®:¼ýÀÚ(2~3ÀÚ¸®)\nÀç°í:¼ýÀÚ(2~3ÀÚ¸®)");
				f2.getContentPane().add(area);
				area.setFont(new Font("±¼¸²", Font.BOLD, 25));
				area.setEditable(false);
				f2.setBounds(800, 90, 700, 500);
				f2.setResizable(false);
				f2.setVisible(true);
			}
		}
	}
	//¸ðµç ÇÚµåÆùÀ» °Ë»öÇÏ·Á´Â ¸Þ¼Òµå
	public void selectAllPhone() {
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectAllPhoneList();
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "ÀúÀåµÈ ÈÞ´ëÆùÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		for(int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		
		for(PhoneDTO phone : phoneList) {
			
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(phone.getMdnm());
			rowData.add(phone.getPhname());
			rowData.add(phone.getColor());
			rowData.add(phone.getMemory());
			rowData.add(phone.getStock());
			model.addRow(rowData);
			
		}
		cmd = 0;
	}
	//ÇÚµåÆùÀ» ¸ðµ¨¸íÀ» ÀÌ¿ëÇÏ¿© °Ë»öÇÏ·Á´Â ¸Þ¼Òµå
	public void searchmdnmPhone() {
		try {
		
		String mdnm = Modelfield.getText();
		
		if(mdnm == null || mdnm.equals("")) {
		
		JOptionPane.showMessageDialog(this, "¸ðµ¨¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		Modelfield.requestFocus();
		return;
		
		}
		
		
		String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
		if(!Pattern.matches(mdnmReg, mdnm)) {
		JOptionPane.showMessageDialog(this, "¿Ã¹Ù¸£°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.(ex:¾ÆÀÌÆù 12 ºí·¢ 64GB-> IP12B64");
		Modelfield.requestFocus();
		return;
		}
	
		PhoneDTO phone = PhoneDAO.getDAO().selectMdnmPhone(mdnm);
						
		if(phone == null)
		{
			JOptionPane.showMessageDialog(this, "ÈÞ´ëÆù Á¤º¸°¡ ¾ø½À´Ï´Ù.");
			Phonefield.requestFocus();
			Phonefield.setText("");
			return;
		}
		
		Modelfield.setText(phone.getMdnm());
		Phonefield.setText(phone.getPhname());
		Huefield.setText(phone.getColor());
		Memoryfield.setText("" + phone.getMemory());
		stockfield.setText("" + phone.getStock());
		
		Modelfield.setEnabled(false);
		Phonefield.setEnabled(false);
		Huefield.setEnabled(false);
		Memoryfield.setEnabled(false);
		stockfield.requestFocus();
		cmd = 4;
		}catch (Exception e) {
		JOptionPane.showMessageDialog(this, "ÀÔ·Â°ª¿¡ ¿À·ù°¡ ÀÖ½À´Ï´Ù.");
		}
	}
	//ÇÚµåÆùÀ» ÇÚµåÆù ÀÌ¸§À» ÀÌ¿ëÇÏ¿© °Ë»öÇÏ·Á´Â ¸Þ¼Òµå
	public void selectPhone() {
		try {
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÈÞ´ëÆù¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Phonefield.requestFocus();
			return;
		}
		/*String nameReg = "¾ÆÀÌÆù\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÈÞ´ëÆù¸íÀ» ¿Ã¹Ù¸£°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.(ex:¾ÆÀÌÆù 12 PRO)");
			Phonefield.requestFocus();
			return;
		}
		*/
		
		
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectPhnamePhoneList(name); 	
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "ÀúÀåµÈ ÈÞ´ëÆùÁ¤º¸°¡ ¾ø½À´Ï´Ù.");
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		for(int i = model.getRowCount(); i>0;i-- ) {
			
			model.removeRow(0);
		}
		
		for(PhoneDTO phone: phoneList) {
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(phone.getMdnm());
			rowData.add(phone.getPhname());
			rowData.add(phone.getColor());
			rowData.add(phone.getMemory());
			rowData.add(phone.getStock());
			model.addRow(rowData);
		}
	
	
	

	
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ÀÔ·Â°ª¿¡ ¿À·ù°¡ ÀÖ½À´Ï´Ù.");
	
		}
	}
	//ÇÚµåÆù Á¤º¸¸¦ ¼öÁ¤ÇÏ·Á´Â ¸Þ¼Òµå
	public void updateStock() {
		try {
		String mdnm = Modelfield.getText();
		
		String name = Phonefield.getText();
		String color = Huefield.getText();
		String memorys = Memoryfield.getText();
		int memory = Integer.parseInt(memorys);
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "Àç°í¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"Àç°í´Â 2~3ÀÚ¸®ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù.");
			stockfield.requestFocus();
			return;
		}
		int stock = Integer.parseInt(stocks);
		PhoneDTO phone = new PhoneDTO();
		
		phone.setMdnm(mdnm);
		phone.setPhname(name);
		phone.setColor(color);
		phone.setMemory(memory);
		phone.setStock(stock);
		
		int rows = PhoneDAO.getDAO().updatePhone(phone);
		
		JOptionPane.showMessageDialog(this, rows + "´ëÀÇ ÈÞ´ëÆùÁ¤º¸¸¦ º¯°æÇÏ¿´½À´Ï´Ù.");
		selectAllPhone();
		Buttoninit();
		fieldclear();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ÀÔ·Â°ª¿¡ ¿À·ù°¡ ÀÖ½À´Ï´Ù.");
		}

	}
	//ÇÚµåÆù Á¤º¸¸¦ »èÁ¦ÇÏ·Á´Â ¸Þ¼Òµå
	public void deletePhone() {
		try {
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "¸ðµ¨¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "¿Ã¹Ù¸£°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.(ex:¾ÆÀÌÆù 12 ºí·¢ 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
			
		
		
		int rows = PhoneDAO.getDAO().deletePhone(mdnm);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this,rows + "´ëÀÇ ÈÞ´ëÆùÁ¤º¸¸¦ »èÁ¦ÇÏ¿´½À´Ï´Ù.");
			selectAllPhone();
		} else {
			JOptionPane.showMessageDialog(this,"»èÁ¦ÇÏ°íÀÚÇÏ´Â ÈÞ´ëÆùÀÇ ¸ðµ¨¹øÈ£°¡ ¾ø½À´Ï´Ù.");
			
		}
		Buttoninit();
		fieldinitf();
		fieldclear();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ÀÔ·Â°ª¿¡ ¿À·ù°¡ ÀÖ½À´Ï´Ù.");
		}
		
	}
	//ÇÚµåÆù Á¤º¸¸¦ Ãß°¡ÇÏ·Á´Â ¸Þ¼Òµå
	public void addPhone() {
		try {
		//¸ðµ¨¸íÀÇ Á¤±ÔÇ¥Çö½Ä : IP(¾ÆÀÌÆùÀÇ ÁÙÀÓ¸») + ¼ýÀÚ È¤Àº ¹®ÀÚ(1~3ÀÚ¸®(PRO³ªMAXÀÎ °æ¿ì P³ª M Ãß°¡))(ex)¾ÆÀÌÆù 11 PRO-> 11P, ¾ÆÀÌÆù 8 -> 08) 
		//+ »ö±ò(¿µ¹®ÀÚ ´ë¹®ÀÚ)(ex)Black -> B) + ¿ë·®(¼ýÀÚ)(ex)128GB -> 128
		//
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "¸ðµ¨¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "¿Ã¹Ù¸£°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.(ex:¾ÆÀÌÆù 12 ºí·¢ 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
		if(PhoneDAO.getDAO().selectMdnmPhone(mdnm) != null){
			JOptionPane.showMessageDialog(this, "ÀÌ¹Ì »ç¿ëÁßÀÎ ¸ðµ¨¹øÈ£ÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä.");
			Modelfield.requestFocus();
			return;
		}
		//ÀÌ¸§ÀÇ Á¤±Ô Ç¥Çö½Ä : ¾ÆÀÌÆù 8 È¤Àº ¾ÆÀÌÆù SE Ã³·³ µÚ¿¡ ¼ýÀÚ È¤Àº ¹®ÀÚ 
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "ÈÞ´ëÆù¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Phonefield.requestFocus();
			return;
		}
		String nameReg = "¾ÆÀÌÆù\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "ÈÞ´ëÆù¸íÀ» ¿Ã¹Ù¸£°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.(ex:¾ÆÀÌÆù 12)");
			Phonefield.requestFocus();
			return;
		}	
		//»ö±ò Á¤±ÔÇ¥Çö½Ä : ÇÑ±Û (ex)½ºÆäÀÌ½º ±×·¹ÀÌ, ºí·¢)
		String color = Huefield.getText();
		if(color.equals("")) {
			JOptionPane.showMessageDialog(this, "»ö±òÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Huefield.requestFocus();
			return;
		}
		
		String ColorReg ="[°¡-ÆR]{2,10}";
		String ColorReg2 = "[°¡-ÆR]{2,6}\\s[°¡-ÆR]{2,6}";
		if(!Pattern.matches(ColorReg, color) && !Pattern.matches(ColorReg2, color)) {
			JOptionPane.showMessageDialog(this,"ÇÑ±Û·Î 2~20±ÛÀÚÀÌ³»·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
		}
		//memory Á¤±ÔÇ¥Çö½Ä : ¼ýÀÚ 2 ~ 3ÀÚ¸® ex)128GB -> 128
		String memorys = Memoryfield.getText();
		if(memorys.equals("")) {
			JOptionPane.showMessageDialog(this, "¿ë·®À» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			Memoryfield.requestFocus();
			return;
		}
		
		String memoryReg = "\\d{2,3}";
		if(!Pattern.matches(memoryReg, memorys)) {
			JOptionPane.showMessageDialog(this,"¿ë·®Àº 2~3ÀÚ¸®ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù.");
			Memoryfield.requestFocus();
			return;
		}
		int memory = Integer.parseInt(memorys);
		//stock Á¤±ÔÇ¥Çö½Ä : ¼ýÀÚ 2 ~ 3ÀÚ¸® ex)128 -> 128
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "Àç°í¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"Àç°í´Â 2~3ÀÚ¸®ÀÇ ¼ýÀÚ·Î ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù.");
			stockfield.requestFocus();
			return;
		}
		int stock = Integer.parseInt(stocks);
		PhoneDTO phone = new PhoneDTO();
		
		phone.setMdnm(mdnm);
		phone.setPhname(name.trim());
		phone.setColor(color);
		phone.setMemory(memory);
		phone.setStock(stock);
		
		int rows = PhoneDAO.getDAO().insertPhone(phone);
		
		JOptionPane.showMessageDialog(this, rows + "´ëÀÇ ÈÞ´ëÆùÁ¤º¸¸¦ Ãß°¡ÇÏ¿´½À´Ï´Ù.");
		
		selectAllPhone();
		fieldclear();
		Buttoninit();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ÀÔ·Â°ª¿¡ ¿À·ù°¡ ÀÖ½À´Ï´Ù.");
		}
	}
	//±âÁ¾º° Àç°í ÇÕ°è ±¸ÇÏ±â
	public void SelectPhnameStockavg() {
	
		List<PhoneDTO> AllphoneList = PhoneDAO.getDAO().selectAllPhoneList();
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectPhnameList();
		
		
		DefaultTableModel model = (DefaultTableModel)table2.getModel();
		
		for(int i = model.getRowCount(); i > 0; i--) {
			model.removeRow(0);
		}
		
		for(PhoneDTO phone : phoneList) {
			
			Vector<Object> rowData = new Vector<Object>();
			rowData.add(phone.getPhname());
			int sum = 0;
			int cnt = 0;
			int avg;
			DefaultTableModel model2 = (DefaultTableModel)table.getModel();
			
			for(int i = model2.getRowCount(); i > 0; i--) {
				model2.removeRow(0);
			}
			for(PhoneDTO phone2 : AllphoneList) {
				if(phone2.getPhname().equals(rowData.elementAt(0))) {
					sum += phone2.getStock();
					cnt++;
				}
			}
			avg = sum / cnt;
			rowData.add(sum);
		model.addRow(rowData);
		}
	}
}




