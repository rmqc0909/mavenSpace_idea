package cn.tk.inner_class.anonymous_inner_class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by xiedan11 on 2016/10/19.
 */
class TalkingClock {
    public void start(int interval, final boolean beep) {
        ActionListener listener = new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date ();
                System.out.println ("At the tone, the time is " + now);
            }
        };
        Timer timer = new Timer (interval, listener);
        timer.start ();
    }
}
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock ();
        talkingClock.start (1000, true);
        JOptionPane.showMessageDialog (null, "Quit program?");
        System.exit (0);
    }
}
