package Lab6;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CirculationRenderer extends DefaultTableCellRenderer {
    public CirculationRenderer() {
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) return this;
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        renderer.setBackground(column == 4 ? (Integer)value > 10000 ? Color.GREEN : Color.LIGHT_GRAY : Color.WHITE);
        return renderer;
    }
}
