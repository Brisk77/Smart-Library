public class StatusCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Assume column 4 is "Status" (Available/Borrowed)
        String status = table.getValueAt(row, 4).toString();
        
        if (status.equalsIgnoreCase("Available")) {
            c.setForeground(new Color(0, 128, 0)); // Green
        } else if (status.equalsIgnoreCase("Borrowed")) {
            c.setForeground(Color.RED);
        } else if (status.equalsIgnoreCase("Overdue")) {
            c.setBackground(new Color(255, 200, 200)); // Light Red Background
        }
        
        return c;
    }
}
