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
	//필드 초기화 true 상태
	public void fieldinit() {
		Modelfield.setEnabled(true);
		Phonefield.setEnabled(true);
		stockfield.setEnabled(true);
		Huefield.setEnabled(true);
		Memoryfield.setEnabled(true);	
	}
	//필드 초기화 false 상태
	public void fieldinitf() {
		Modelfield.setEnabled(false);
		Phonefield.setEnabled(false);
		stockfield.setEnabled(false);
		Huefield.setEnabled(false);
		Memoryfield.setEnabled(false);	
	}
					
	//버튼 초기화 true 상태
	public void Buttoninit() {
		SELECTALL.setEnabled(true);
		SELECT.setEnabled(true);
		ADD.setEnabled(true);
		UPDATE.setEnabled(true);
		DELETE.setEnabled(true);	
	}
	//버튼 초기화 false 상태
	public void Buttoninitf() {
		SELECTALL.setEnabled(false);
		SELECT.setEnabled(false);
		ADD.setEnabled(false);
		UPDATE.setEnabled(false);
		DELETE.setEnabled(false);	
	}
	//필드 초기화 공백 상태
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
	
	JLabel label1 = new JLabel("통신사");
	JLabel label2 = new JLabel("제조사");
	JLabel label3 = new JLabel("기종");
	JLabel label4 = new JLabel("색깔");
	JLabel label5 = new JLabel("용량");
		
	private static final long serialVersionUID = 1L;

	//버튼 추가
	JButton SELECT = new JButton("\uAC80\uC0C9");
	JButton RegButton;
	JButton UPDATE = new JButton("수정");
	JButton DELETE = new JButton("삭제");
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
	
	label.setText("휴대폰 재고관리 프로그램");
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setFont(new Font("굴림", Font.BOLD, 20));
	
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
	Modelfield.setFont(new Font("굴림", Font.PLAIN, 22));
	Modelfield.setBounds(257, 78, 360, 35);
	
	getContentPane().add(Modelfield);
	Modelfield.setColumns(10);
	
	Phonefield = new JTextField();
	Phonefield.setFont(new Font("굴림", Font.PLAIN, 22));
	Phonefield.setColumns(10);
	Phonefield.setBounds(257, 138, 360, 35);
	getContentPane().add(Phonefield);
	
	Huefield = new JTextField();
	Huefield.setFont(new Font("굴림", Font.PLAIN, 22));
	Huefield.setColumns(10);
	Huefield.setBounds(257, 198, 360, 35);
	getContentPane().add(Huefield);
	
	Memoryfield = new JTextField();
	Memoryfield.setFont(new Font("굴림", Font.PLAIN, 22));
	Memoryfield.setColumns(10);
	Memoryfield.setBounds(257, 258, 360, 35);
	getContentPane().add(Memoryfield);
	
	stockfield = new JTextField();
	stockfield.setFont(new Font("굴림", Font.PLAIN, 22));
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
	
	//테이블 생성
	Object [] columnName = {"모델번호","기종","색깔","용량(GB)","재고"};
	Object [] columnName2 = {"기종","재고 합"};
	
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
		new PhoneApp("휴대폰 재고관리 프로그램");	
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
				//초기 상태
				cmd = 0;
			}
			else if((JButton)eventSource == SELECTALL) {
				selectAllPhone();
				
			
			}
			else if((JButton)eventSource == SELECT) {
				//1은 select 상태
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
				//2는 올바른 값을 입력하기 전 상태
				if(cmd != 2 && cmd != 5)
				{
					selectAllPhone();
					fieldinitf();
					Modelfield.setEnabled(true);
					Buttoninitf();
					UPDATE.setEnabled(true);
					cmd =2;	
				//5는 값을 수정하려는 상태
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
			//3은 값을 추가하려는 상태
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
			//4는 값을 추가하려는 상태
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
				JFrame f2 = new JFrame("※값 입력 규칙※");
				JTextArea area = new JTextArea("모델번호 : IP + 1~2자리 숫자 또는 문자 + 용량\n기종 : 아이폰 + 숫자 + (PLUS)"
						+ "(PRO) + (MAX)\n(만약 기종이 PLUS이거나 PRO이거나 PRO MAX 이면)"
						+ "\n색깔:한글로\n용량:숫자(2~3자리)\n재고:숫자(2~3자리)");
				f2.getContentPane().add(area);
				area.setFont(new Font("굴림", Font.BOLD, 25));
				area.setEditable(false);
				f2.setBounds(800, 90, 700, 500);
				f2.setResizable(false);
				f2.setVisible(true);
			}
		}
	}
	//모든 핸드폰을 검색하려는 메소드
	public void selectAllPhone() {
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectAllPhoneList();
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "저장된 휴대폰정보가 없습니다.");
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
	//핸드폰을 모델명을 이용하여 검색하려는 메소드
	public void searchmdnmPhone() {
		try {
		
		String mdnm = Modelfield.getText();
		
		if(mdnm == null || mdnm.equals("")) {
		
		JOptionPane.showMessageDialog(this, "모델명을 반드시 입력해 주세요.");
		Modelfield.requestFocus();
		return;
		
		}
		
		
		String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
		if(!Pattern.matches(mdnmReg, mdnm)) {
		JOptionPane.showMessageDialog(this, "올바르게 입력해 주세요.(ex:아이폰 12 블랙 64GB-> IP12B64");
		Modelfield.requestFocus();
		return;
		}
	
		PhoneDTO phone = PhoneDAO.getDAO().selectMdnmPhone(mdnm);
						
		if(phone == null)
		{
			JOptionPane.showMessageDialog(this, "휴대폰 정보가 없습니다.");
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
		JOptionPane.showMessageDialog(this, "입력값에 오류가 있습니다.");
		}
	}
	//핸드폰을 핸드폰 이름을 이용하여 검색하려는 메소드
	public void selectPhone() {
		try {
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "휴대폰명을 반드시 입력해 주세요.");
			Phonefield.requestFocus();
			return;
		}
		/*String nameReg = "아이폰\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "휴대폰명을 올바르게 입력해 주세요.(ex:아이폰 12 PRO)");
			Phonefield.requestFocus();
			return;
		}
		*/
		
		
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectPhnamePhoneList(name); 	
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 휴대폰정보가 없습니다.");
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
			JOptionPane.showMessageDialog(this, "입력값에 오류가 있습니다.");
	
		}
	}
	//핸드폰 정보를 수정하려는 메소드
	public void updateStock() {
		try {
		String mdnm = Modelfield.getText();
		
		String name = Phonefield.getText();
		String color = Huefield.getText();
		String memorys = Memoryfield.getText();
		int memory = Integer.parseInt(memorys);
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "재고를 반드시 입력해 주세요.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"재고는 2~3자리의 숫자로 입력하셔야 합니다.");
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
		
		JOptionPane.showMessageDialog(this, rows + "대의 휴대폰정보를 변경하였습니다.");
		selectAllPhone();
		Buttoninit();
		fieldclear();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "입력값에 오류가 있습니다.");
		}

	}
	//핸드폰 정보를 삭제하려는 메소드
	public void deletePhone() {
		try {
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "모델명을 반드시 입력해 주세요.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "올바르게 입력해 주세요.(ex:아이폰 12 블랙 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
			
		
		
		int rows = PhoneDAO.getDAO().deletePhone(mdnm);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this,rows + "대의 휴대폰정보를 삭제하였습니다.");
			selectAllPhone();
		} else {
			JOptionPane.showMessageDialog(this,"삭제하고자하는 휴대폰의 모델번호가 없습니다.");
			
		}
		Buttoninit();
		fieldinitf();
		fieldclear();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "입력값에 오류가 있습니다.");
		}
		
	}
	//핸드폰 정보를 추가하려는 메소드
	public void addPhone() {
		try {
		//모델명의 정규표현식 : IP(아이폰의 줄임말) + 숫자 혹은 문자(1~3자리(PRO나MAX인 경우 P나 M 추가))(ex)아이폰 11 PRO-> 11P, 아이폰 8 -> 08) 
		//+ 색깔(영문자 대문자)(ex)Black -> B) + 용량(숫자)(ex)128GB -> 128
		//
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "모델명을 반드시 입력해 주세요.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "올바르게 입력해 주세요.(ex:아이폰 12 블랙 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
		if(PhoneDAO.getDAO().selectMdnmPhone(mdnm) != null){
			JOptionPane.showMessageDialog(this, "이미 사용중인 모델번호입니다. 다시 입력해주세요.");
			Modelfield.requestFocus();
			return;
		}
		//이름의 정규 표현식 : 아이폰 8 혹은 아이폰 SE 처럼 뒤에 숫자 혹은 문자 
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "휴대폰명을 반드시 입력해 주세요.");
			Phonefield.requestFocus();
			return;
		}
		String nameReg = "아이폰\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "휴대폰명을 올바르게 입력해 주세요.(ex:아이폰 12)");
			Phonefield.requestFocus();
			return;
		}	
		//색깔 정규표현식 : 한글 (ex)스페이스 그레이, 블랙)
		String color = Huefield.getText();
		if(color.equals("")) {
			JOptionPane.showMessageDialog(this, "색깔을 반드시 입력해 주세요.");
			Huefield.requestFocus();
			return;
		}
		
		String ColorReg ="[가-힣]{2,10}";
		String ColorReg2 = "[가-힣]{2,6}\\s[가-힣]{2,6}";
		if(!Pattern.matches(ColorReg, color) && !Pattern.matches(ColorReg2, color)) {
			JOptionPane.showMessageDialog(this,"한글로 2~20글자이내로 입력해 주세요.");
		}
		//memory 정규표현식 : 숫자 2 ~ 3자리 ex)128GB -> 128
		String memorys = Memoryfield.getText();
		if(memorys.equals("")) {
			JOptionPane.showMessageDialog(this, "용량을 반드시 입력해 주세요.");
			Memoryfield.requestFocus();
			return;
		}
		
		String memoryReg = "\\d{2,3}";
		if(!Pattern.matches(memoryReg, memorys)) {
			JOptionPane.showMessageDialog(this,"용량은 2~3자리의 숫자로 입력하셔야 합니다.");
			Memoryfield.requestFocus();
			return;
		}
		int memory = Integer.parseInt(memorys);
		//stock 정규표현식 : 숫자 2 ~ 3자리 ex)128 -> 128
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "재고를 반드시 입력해 주세요.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"재고는 2~3자리의 숫자로 입력하셔야 합니다.");
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
		
		JOptionPane.showMessageDialog(this, rows + "대의 휴대폰정보를 추가하였습니다.");
		
		selectAllPhone();
		fieldclear();
		Buttoninit();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "입력값에 오류가 있습니다.");
		}
	}
	//기종별 재고 합계 구하기
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




