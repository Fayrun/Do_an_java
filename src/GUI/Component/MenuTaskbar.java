package GUI.Component;

import GUI.Main;
import GUI.Panel.QuanLyThuocTinhSP;
import GUI.Panel.QuatPanel;
import GUI.Panel.TrangChu;
import GUI.Panel.PhieuNhapPanel;
import GUI.Panel.NhaCungCapPanel;
import GUI.Panel.PhieuXuatPanel;
import GUI.Panel.KhuyenMaiPanel;
import GUI.Log_In;

import java.awt.*;
import javax.swing.*;

public class MenuTaskbar extends JPanel {

    private Main mainFrame;

    public MenuTaskbar(Main main) {
        this.mainFrame = main;
        initComponent();
    }

    private void initComponent() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);

        // Phần hiển thị thông tin user ở trên (ví dụ cứng)
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        userPanel.setBackground(Color.WHITE);
        JLabel lblUserName = new JLabel("Nhân viên: Nguyễn Văn A");
        lblUserName.setFont(lblUserName.getFont().deriveFont(Font.BOLD, 14f));
        userPanel.add(lblUserName);

        this.add(userPanel, BorderLayout.NORTH);

        // Phần các nút chức năng
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1, 0, 5));
        menuPanel.setBackground(Color.WHITE);

        // Nút Trang chủ
        JButton btnTrangChu = new JButton("Trang chủ");
        btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
        btnTrangChu.addActionListener(e -> {
            mainFrame.setPanel(new TrangChu());
        });
        menuPanel.add(btnTrangChu);

        // Nút Quản lý quạt
        JButton btnQuanLyQuat = new JButton("Quản lý quạt");
        btnQuanLyQuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnQuanLyQuat.addActionListener(e -> {
            mainFrame.setPanel(new QuatPanel());
        });
        menuPanel.add(btnQuanLyQuat);

        // Nút Quản lý thuộc tính
        JButton btnThongtinChucNang = new JButton("Thông tin chức năng");
        btnThongtinChucNang.setHorizontalAlignment(SwingConstants.LEFT);
        btnThongtinChucNang.addActionListener(e -> {
            mainFrame.setPanel(new QuanLyThuocTinhSP(mainFrame));
        });

        menuPanel.add(btnThongtinChucNang);

        // Nút Quản lý phiếu nhập
        JButton btnPhieuNhap = new JButton("Phiếu nhập");
        btnPhieuNhap.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuNhap.addActionListener(e -> {
            mainFrame.setPanel(new PhieuNhapPanel());
        });
        menuPanel.add(btnPhieuNhap);

        // Nút Nhà cung cấp
        JButton btnNhaCungCap = new JButton("Nhà Cung Cấp");
        btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhaCungCap.addActionListener(e -> {
            mainFrame.setPanel(new NhaCungCapPanel());
        });
        menuPanel.add(btnNhaCungCap);

        // Nút Quản lý phiếu Xuất
        JButton btnPhieuXuat = new JButton("Phiếu xuất");
        btnPhieuXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnPhieuXuat.addActionListener(e -> {
            mainFrame.setPanel(new PhieuXuatPanel());
        });
        menuPanel.add(btnPhieuXuat);

        // Nút quản lý khuyến mãi
        JButton btnKhuyenMai = new JButton("Khuyến mãi");
        btnKhuyenMai.addActionListener(e -> {
            mainFrame.setPanel(new KhuyenMaiPanel());
        });
        menuPanel.add(btnKhuyenMai);

        // 🔹 **Nút Đăng xuất**
        JButton btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnDangXuat.setForeground(Color.RED); // Màu đỏ để nổi bật
        btnDangXuat.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(null,
                    "Bạn có chắc chắn muốn đăng xuất?", "Đăng xuất",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if (input == JOptionPane.OK_OPTION) {
                Log_In login = new Log_In();
                mainFrame.dispose(); // Đóng cửa sổ hiện tại
                login.setVisible(true); // Mở lại màn hình đăng nhập
            }
        });
        menuPanel.add(btnDangXuat);

        // Thêm các nút khác nếu cần
        this.add(menuPanel, BorderLayout.CENTER);
    }
}
