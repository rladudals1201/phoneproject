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
	//�ʵ� �ʱ�ȭ true ����
	public void fieldinit() {
		Modelfield.setEnabled(true);
		Phonefield.setEnabled(true);
		stockfield.setEnabled(true);
		Huefield.setEnabled(true);
		Memoryfield.setEnabled(true);	
	}
	//�ʵ� �ʱ�ȭ false ����
	public void fieldinitf() {
		Modelfield.setEnabled(false);
		Phonefield.setEnabled(false);
		stockfield.setEnabled(false);
		Huefield.setEnabled(false);
		Memoryfield.setEnabled(false);	
	}
					
	//��ư �ʱ�ȭ true ����
	public void Buttoninit() {
		SELECTALL.setEnabled(true);
		SELECT.setEnabled(true);
		ADD.setEnabled(true);
		UPDATE.setEnabled(true);
		DELETE.setEnabled(true);	
	}
	//��ư �ʱ�ȭ false ����
	public void Buttoninitf() {
		SELECTALL.setEnabled(false);
		SELECT.setEnabled(false);
		ADD.setEnabled(false);
		UPDATE.setEnabled(false);
		DELETE.setEnabled(false);	
	}
	//�ʵ� �ʱ�ȭ ���� ����
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
	
	JLabel label1 = new JLabel("��Ż�");
	JLabel label2 = new JLabel("������");
	JLabel label3 = new JLabel("����");
	JLabel label4 = new JLabel("����");
	JLabel label5 = new JLabel("�뷮");
		
	private static final long serialVersionUID = 1L;

	//��ư �߰�
	JButton SELECT = new JButton("\uAC80\uC0C9");
	JButton RegButton;
	JButton UPDATE = new JButton("����");
	JButton DELETE = new JButton("����");
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
	
	label.setText("�޴��� ������ ���α׷�");
	label.setHorizontalAlignment(JLabel.CENTER);
	label.setFont(new Font("����", Font.BOLD, 20));
	
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
	Modelfield.setFont(new Font("����", Font.PLAIN, 22));
	Modelfield.setBounds(257, 78, 360, 35);
	
	getContentPane().add(Modelfield);
	Modelfield.setColumns(10);
	
	Phonefield = new JTextField();
	Phonefield.setFont(new Font("����", Font.PLAIN, 22));
	Phonefield.setColumns(10);
	Phonefield.setBounds(257, 138, 360, 35);
	getContentPane().add(Phonefield);
	
	Huefield = new JTextField();
	Huefield.setFont(new Font("����", Font.PLAIN, 22));
	Huefield.setColumns(10);
	Huefield.setBounds(257, 198, 360, 35);
	getContentPane().add(Huefield);
	
	Memoryfield = new JTextField();
	Memoryfield.setFont(new Font("����", Font.PLAIN, 22));
	Memoryfield.setColumns(10);
	Memoryfield.setBounds(257, 258, 360, 35);
	getContentPane().add(Memoryfield);
	
	stockfield = new JTextField();
	stockfield.setFont(new Font("����", Font.PLAIN, 22));
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
	
	//���̺� ����
	Object [] columnName = {"�𵨹�ȣ","����","����","�뷮(GB)","���"};
	Object [] columnName2 = {"����","��� ��"};
	
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
		new PhoneApp("�޴��� ������ ���α׷�");	
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
				//�ʱ� ����
				cmd = 0;
			}
			else if((JButton)eventSource == SELECTALL) {
				selectAllPhone();
				
			
			}
			else if((JButton)eventSource == SELECT) {
				//1�� select ����
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
				//2�� �ùٸ� ���� �Է��ϱ� �� ����
				if(cmd != 2 && cmd != 5)
				{
					selectAllPhone();
					fieldinitf();
					Modelfield.setEnabled(true);
					Buttoninitf();
					UPDATE.setEnabled(true);
					cmd =2;	
				//5�� ���� �����Ϸ��� ����
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
			//3�� ���� �߰��Ϸ��� ����
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
			//4�� ���� �߰��Ϸ��� ����
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
				JFrame f2 = new JFrame("�ذ� �Է� ��Ģ��");
				JTextArea area = new JTextArea("�𵨹�ȣ : IP + 1~2�ڸ� ���� �Ǵ� ���� + �뷮\n���� : ������ + ���� + (PLUS)"
						+ "(PRO) + (MAX)\n(���� ������ PLUS�̰ų� PRO�̰ų� PRO MAX �̸�)"
						+ "\n����:�ѱ۷�\n�뷮:����(2~3�ڸ�)\n���:����(2~3�ڸ�)");
				f2.getContentPane().add(area);
				area.setFont(new Font("����", Font.BOLD, 25));
				area.setEditable(false);
				f2.setBounds(800, 90, 700, 500);
				f2.setResizable(false);
				f2.setVisible(true);
			}
		}
	}
	//��� �ڵ����� �˻��Ϸ��� �޼ҵ�
	public void selectAllPhone() {
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectAllPhoneList();
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "����� �޴��������� �����ϴ�.");
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
	//�ڵ����� �𵨸��� �̿��Ͽ� �˻��Ϸ��� �޼ҵ�
	public void searchmdnmPhone() {
		try {
		
		String mdnm = Modelfield.getText();
		
		if(mdnm == null || mdnm.equals("")) {
		
		JOptionPane.showMessageDialog(this, "�𵨸��� �ݵ�� �Է��� �ּ���.");
		Modelfield.requestFocus();
		return;
		
		}
		
		
		String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
		if(!Pattern.matches(mdnmReg, mdnm)) {
		JOptionPane.showMessageDialog(this, "�ùٸ��� �Է��� �ּ���.(ex:������ 12 �� 64GB-> IP12B64");
		Modelfield.requestFocus();
		return;
		}
	
		PhoneDTO phone = PhoneDAO.getDAO().selectMdnmPhone(mdnm);
						
		if(phone == null)
		{
			JOptionPane.showMessageDialog(this, "�޴��� ������ �����ϴ�.");
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
		JOptionPane.showMessageDialog(this, "�Է°��� ������ �ֽ��ϴ�.");
		}
	}
	//�ڵ����� �ڵ��� �̸��� �̿��Ͽ� �˻��Ϸ��� �޼ҵ�
	public void selectPhone() {
		try {
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�޴������� �ݵ�� �Է��� �ּ���.");
			Phonefield.requestFocus();
			return;
		}
		/*String nameReg = "������\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�޴������� �ùٸ��� �Է��� �ּ���.(ex:������ 12 PRO)");
			Phonefield.requestFocus();
			return;
		}
		*/
		
		
		
		List<PhoneDTO> phoneList = PhoneDAO.getDAO().selectPhnamePhoneList(name); 	
		
		if(phoneList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "����� �޴��������� �����ϴ�.");
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
			JOptionPane.showMessageDialog(this, "�Է°��� ������ �ֽ��ϴ�.");
	
		}
	}
	//�ڵ��� ������ �����Ϸ��� �޼ҵ�
	public void updateStock() {
		try {
		String mdnm = Modelfield.getText();
		
		String name = Phonefield.getText();
		String color = Huefield.getText();
		String memorys = Memoryfield.getText();
		int memory = Integer.parseInt(memorys);
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "��� �ݵ�� �Է��� �ּ���.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"���� 2~3�ڸ��� ���ڷ� �Է��ϼž� �մϴ�.");
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
		
		JOptionPane.showMessageDialog(this, rows + "���� �޴��������� �����Ͽ����ϴ�.");
		selectAllPhone();
		Buttoninit();
		fieldclear();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "�Է°��� ������ �ֽ��ϴ�.");
		}

	}
	//�ڵ��� ������ �����Ϸ��� �޼ҵ�
	public void deletePhone() {
		try {
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "�𵨸��� �ݵ�� �Է��� �ּ���.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "�ùٸ��� �Է��� �ּ���.(ex:������ 12 �� 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
			
		
		
		int rows = PhoneDAO.getDAO().deletePhone(mdnm);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this,rows + "���� �޴��������� �����Ͽ����ϴ�.");
			selectAllPhone();
		} else {
			JOptionPane.showMessageDialog(this,"�����ϰ����ϴ� �޴����� �𵨹�ȣ�� �����ϴ�.");
			
		}
		Buttoninit();
		fieldinitf();
		fieldclear();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "�Է°��� ������ �ֽ��ϴ�.");
		}
		
	}
	//�ڵ��� ������ �߰��Ϸ��� �޼ҵ�
	public void addPhone() {
		try {
		//�𵨸��� ����ǥ���� : IP(�������� ���Ӹ�) + ���� Ȥ�� ����(1~3�ڸ�(PRO��MAX�� ��� P�� M �߰�))(ex)������ 11 PRO-> 11P, ������ 8 -> 08) 
		//+ ����(������ �빮��)(ex)Black -> B) + �뷮(����)(ex)128GB -> 128
		//
			String mdnm = Modelfield.getText();
			
			if(mdnm == null || mdnm.equals("")) {
			
			JOptionPane.showMessageDialog(this, "�𵨸��� �ݵ�� �Է��� �ּ���.");
			Modelfield.requestFocus();
			return;
			
			}
			String mdnmReg = "IP\\d{0,2}[A-Z]{1,4}\\d{2,3}";
			if(!Pattern.matches(mdnmReg, mdnm)) {
				JOptionPane.showMessageDialog(this, "�ùٸ��� �Է��� �ּ���.(ex:������ 12 �� 64GB-> IP12B64");
				Modelfield.requestFocus();
				return;
			}
		if(PhoneDAO.getDAO().selectMdnmPhone(mdnm) != null){
			JOptionPane.showMessageDialog(this, "�̹� ������� �𵨹�ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			Modelfield.requestFocus();
			return;
		}
		//�̸��� ���� ǥ���� : ������ 8 Ȥ�� ������ SE ó�� �ڿ� ���� Ȥ�� ���� 
		String name = Phonefield.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "�޴������� �ݵ�� �Է��� �ּ���.");
			Phonefield.requestFocus();
			return;
		}
		String nameReg = "������\\s[1-9,A-Z]{1,3}\\s{0,1}(PLUS){0,1}(PRO){0,1}\\s{0,1}(MAX){0,1}";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "�޴������� �ùٸ��� �Է��� �ּ���.(ex:������ 12)");
			Phonefield.requestFocus();
			return;
		}	
		//���� ����ǥ���� : �ѱ� (ex)�����̽� �׷���, ��)
		String color = Huefield.getText();
		if(color.equals("")) {
			JOptionPane.showMessageDialog(this, "������ �ݵ�� �Է��� �ּ���.");
			Huefield.requestFocus();
			return;
		}
		
		String ColorReg ="[��-�R]{2,10}";
		String ColorReg2 = "[��-�R]{2,6}\\s[��-�R]{2,6}";
		if(!Pattern.matches(ColorReg, color) && !Pattern.matches(ColorReg2, color)) {
			JOptionPane.showMessageDialog(this,"�ѱ۷� 2~20�����̳��� �Է��� �ּ���.");
		}
		//memory ����ǥ���� : ���� 2 ~ 3�ڸ� ex)128GB -> 128
		String memorys = Memoryfield.getText();
		if(memorys.equals("")) {
			JOptionPane.showMessageDialog(this, "�뷮�� �ݵ�� �Է��� �ּ���.");
			Memoryfield.requestFocus();
			return;
		}
		
		String memoryReg = "\\d{2,3}";
		if(!Pattern.matches(memoryReg, memorys)) {
			JOptionPane.showMessageDialog(this,"�뷮�� 2~3�ڸ��� ���ڷ� �Է��ϼž� �մϴ�.");
			Memoryfield.requestFocus();
			return;
		}
		int memory = Integer.parseInt(memorys);
		//stock ����ǥ���� : ���� 2 ~ 3�ڸ� ex)128 -> 128
		String stocks= stockfield.getText();
		if(stocks.equals("")) {
			JOptionPane.showMessageDialog(this, "��� �ݵ�� �Է��� �ּ���.");
			stockfield.requestFocus();
			return;
		}
		
		String stockReg = "\\d{2,3}";
		if(!Pattern.matches(stockReg, stocks)) {
			JOptionPane.showMessageDialog(this,"���� 2~3�ڸ��� ���ڷ� �Է��ϼž� �մϴ�.");
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
		
		JOptionPane.showMessageDialog(this, rows + "���� �޴��������� �߰��Ͽ����ϴ�.");
		
		selectAllPhone();
		fieldclear();
		Buttoninit();
		fieldinitf();
		cmd = 0;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, "�Է°��� ������ �ֽ��ϴ�.");
		}
	}
	//������ ��� �հ� ���ϱ�
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




