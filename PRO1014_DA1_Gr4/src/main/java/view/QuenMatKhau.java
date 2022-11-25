package view;

import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import service.INhanVienService;
import service.impl.NhanVienImpl;

/**
 *
 * @author fallinluv2003
 */
public class QuenMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form QuenMatKhau
     */
    private INhanVienService nvSer;
    
    public QuenMatKhau() {
        initComponents();
        nvSer = new NhanVienImpl();
        setLocationRelativeTo(null);
    }
    
    /*
    cd C:\Users\HP\OneDrive\Máy tính\DuAn1_GR4\PRO1014_DA1_Gr4; "JAVA_HOME=C:\\Program Files\\Java\\jdk-17.0.1" cmd /c "\"C:\\Program Files\\NetBeans-12.6\\netbeans\\java\\maven\\bin\\mvn.cmd\" -Dexec.vmArgs= \"-Dexec.args=${exec.vmArgs} -classpath %classpath ${exec.mainClass} ${exec.appArgs}\" \"-Dexec.executable=C:\\Program Files\\Java\\jdk-17.0.1\\bin\\java.exe\" -Dexec.mainClass=view.QuanLyHoaDon -Dexec.classpathScope=runtime -Dexec.appArgs= \"-Dmaven.ext.class.path=C:\\Program Files\\NetBeans-12.6\\netbeans\\java\\maven-nblib\\netbeans-eventspy.jar\" -Dfile.encoding=UTF-8 org.codehaus.mojo:exec-maven-plugin:3.0.0:exec"
Running NetBeans Compile On Save execution. Phase execution is skipped and output directories of dependency projects (with Compile on Save turned on) will be used instead of their jar artifacts.
Scanning for projects...

-------------------< com.hibernate:PRO1014_DA1_Gr4 >--------------------
Building PRO1014_DA1_Gr4_Vip_pro 1.0-SNAPSHOT
--------------------------------[ jar ]---------------------------------

--- exec-maven-plugin:3.0.0:exec (default-cli) @ PRO1014_DA1_Gr4 ---
0.I love u
1.I love u
2.I love u
3.I love u
4.I love u
5.I love u
6.I love u
7.I love u
8.I love u
9.I love u
10.I love u
11.I love u
12.I love u
13.I love u
14.I love u
15.I love u
16.I love u
17.I love u
18.I love u
19.I love u
20.I love u
21.I love u
22.I love u
23.I love u
24.I love u
25.I love u
26.I love u
27.I love u
28.I love u
29.I love u
30.I love u
31.I love u
32.I love u
33.I love u
34.I love u
35.I love u
36.I love u
37.I love u
38.I love u
39.I love u
40.I love u
41.I love u
42.I love u
43.I love u
44.I love u
45.I love u
46.I love u
47.I love u
48.I love u
49.I love u
50.I love u
51.I love u
52.I love u
53.I love u
54.I love u
55.I love u
56.I love u
57.I love u
58.I love u
59.I love u
60.I love u
61.I love u
62.I love u
63.I love u
64.I love u
65.I love u
66.I love u
67.I love u
68.I love u
69.I love u
70.I love u
71.I love u
72.I love u
73.I love u
74.I love u
75.I love u
76.I love u
77.I love u
78.I love u
79.I love u
80.I love u
81.I love u
82.I love u
83.I love u
84.I love u
85.I love u
86.I love u
87.I love u
88.I love u
89.I love u
90.I love u
91.I love u
92.I love u
93.I love u
94.I love u
95.I love u
96.I love u
97.I love u
98.I love u
99.I love u
100.I love u
101.I love u
102.I love u
103.I love u
104.I love u
105.I love u
106.I love u
107.I love u
108.I love u
109.I love u
110.I love u
111.I love u
112.I love u
113.I love u
114.I love u
115.I love u
116.I love u
117.I love u
118.I love u
119.I love u
120.I love u
121.I love u
122.I love u
123.I love u
124.I love u
125.I love u
126.I love u
127.I love u
128.I love u
129.I love u
130.I love u
131.I love u
132.I love u
133.I love u
134.I love u
135.I love u
136.I love u
137.I love u
138.I love u
139.I love u
140.I love u
141.I love u
142.I love u
143.I love u
144.I love u
145.I love u
146.I love u
147.I love u
148.I love u
149.I love u
150.I love u
151.I love u
152.I love u
153.I love u
154.I love u
155.I love u
156.I love u
157.I love u
158.I love u
159.I love u
160.I love u
161.I love u
162.I love u
163.I love u
164.I love u
165.I love u
166.I love u
167.I love u
168.I love u
169.I love u
170.I love u
171.I love u
172.I love u
173.I love u
174.I love u
175.I love u
176.I love u
177.I love u
178.I love u
179.I love u
180.I love u
181.I love u
182.I love u
183.I love u
184.I love u
185.I love u
186.I love u
187.I love u
188.I love u
189.I love u
190.I love u
191.I love u
192.I love u
193.I love u
194.I love u
195.I love u
196.I love u
197.I love u
198.I love u
199.I love u
200.I love u
201.I love u
202.I love u
203.I love u
204.I love u
205.I love u
206.I love u
207.I love u
208.I love u
209.I love u
210.I love u
211.I love u
212.I love u
213.I love u
214.I love u
215.I love u
216.I love u
217.I love u
218.I love u
219.I love u
220.I love u
221.I love u
222.I love u
223.I love u
224.I love u
225.I love u
226.I love u
227.I love u
228.I love u
229.I love u
230.I love u
231.I love u
232.I love u
233.I love u
234.I love u
235.I love u
236.I love u
237.I love u
238.I love u
239.I love u
240.I love u
241.I love u
242.I love u
243.I love u
244.I love u
245.I love u
246.I love u
247.I love u
248.I love u
249.I love u
250.I love u
251.I love u
252.I love u
253.I love u
254.I love u
255.I love u
256.I love u
257.I love u
258.I love u
259.I love u
260.I love u
261.I love u
262.I love u
263.I love u
264.I love u
265.I love u
266.I love u
267.I love u
268.I love u
269.I love u
270.I love u
271.I love u
272.I love u
273.I love u
274.I love u
275.I love u
276.I love u
277.I love u
278.I love u
279.I love u
280.I love u
281.I love u
282.I love u
283.I love u
284.I love u
285.I love u
286.I love u
287.I love u
288.I love u
289.I love u
290.I love u
291.I love u
292.I love u
293.I love u
294.I love u
295.I love u
296.I love u
297.I love u
298.I love u
299.I love u
300.I love u
301.I love u
302.I love u
303.I love u
304.I love u
305.I love u
306.I love u
307.I love u
308.I love u
309.I love u
310.I love u
311.I love u
312.I love u
313.I love u
314.I love u
315.I love u
316.I love u
317.I love u
318.I love u
319.I love u
320.I love u
321.I love u
322.I love u
323.I love u
324.I love u
325.I love u
326.I love u
327.I love u
328.I love u
329.I love u
330.I love u
331.I love u
332.I love u
333.I love u
334.I love u
335.I love u
336.I love u
337.I love u
338.I love u
339.I love u
340.I love u
341.I love u
342.I love u
343.I love u
344.I love u
345.I love u
346.I love u
347.I love u
348.I love u
349.I love u
350.I love u
351.I love u
352.I love u
353.I love u
354.I love u
355.I love u
356.I love u
357.I love u
358.I love u
359.I love u
360.I love u
361.I love u
362.I love u
363.I love u
364.I love u
365.I love u
366.I love u
367.I love u
368.I love u
369.I love u
370.I love u
371.I love u
372.I love u
373.I love u
374.I love u
375.I love u
376.I love u
377.I love u
378.I love u
379.I love u
380.I love u
381.I love u
382.I love u
383.I love u
384.I love u
385.I love u
386.I love u
387.I love u
388.I love u
389.I love u
390.I love u
391.I love u
392.I love u
393.I love u
394.I love u
395.I love u
396.I love u
397.I love u
398.I love u
399.I love u
400.I love u
401.I love u
402.I love u
403.I love u
404.I love u
405.I love u
406.I love u
407.I love u
408.I love u
409.I love u
410.I love u
411.I love u
412.I love u
413.I love u
414.I love u
415.I love u
416.I love u
417.I love u
418.I love u
419.I love u
420.I love u
421.I love u
422.I love u
423.I love u
424.I love u
425.I love u
426.I love u
427.I love u
428.I love u
429.I love u
430.I love u
431.I love u
432.I love u
433.I love u
434.I love u
435.I love u
436.I love u
437.I love u
438.I love u
439.I love u
440.I love u
441.I love u
442.I love u
443.I love u
444.I love u
445.I love u
446.I love u
447.I love u
448.I love u
449.I love u
450.I love u
451.I love u
452.I love u
453.I love u
454.I love u
455.I love u
456.I love u
457.I love u
458.I love u
459.I love u
460.I love u
461.I love u
462.I love u
463.I love u
464.I love u
465.I love u
466.I love u
467.I love u
468.I love u
469.I love u
470.I love u
471.I love u
472.I love u
473.I love u
474.I love u
475.I love u
476.I love u
477.I love u
478.I love u
479.I love u
480.I love u
481.I love u
482.I love u
483.I love u
484.I love u
485.I love u
486.I love u
487.I love u
488.I love u
489.I love u
490.I love u
491.I love u
492.I love u
493.I love u
494.I love u
495.I love u
496.I love u
497.I love u
498.I love u
499.I love u
500.I love u
501.I love u
502.I love u
503.I love u
504.I love u
505.I love u
506.I love u
507.I love u
508.I love u
509.I love u
510.I love u
511.I love u
512.I love u
513.I love u
514.I love u
515.I love u
516.I love u
517.I love u
518.I love u
519.I love u
520.I love u
521.I love u
522.I love u
523.I love u
524.I love u
525.I love u
526.I love u
527.I love u
528.I love u
529.I love u
530.I love u
531.I love u
532.I love u
533.I love u
534.I love u
535.I love u
536.I love u
537.I love u
538.I love u
539.I love u
540.I love u
541.I love u
542.I love u
543.I love u
544.I love u
545.I love u
546.I love u
547.I love u
548.I love u
549.I love u
550.I love u
551.I love u
552.I love u
553.I love u
554.I love u
555.I love u
556.I love u
557.I love u
558.I love u
559.I love u
560.I love u
561.I love u
562.I love u
563.I love u
564.I love u
565.I love u
566.I love u
567.I love u
568.I love u
569.I love u
570.I love u
571.I love u
572.I love u
573.I love u
574.I love u
575.I love u
576.I love u
577.I love u
578.I love u
579.I love u
580.I love u
581.I love u
582.I love u
583.I love u
584.I love u
585.I love u
586.I love u
587.I love u
588.I love u
589.I love u
590.I love u
591.I love u
592.I love u
593.I love u
594.I love u
595.I love u
596.I love u
597.I love u
598.I love u
599.I love u
600.I love u
601.I love u
602.I love u
603.I love u
604.I love u
605.I love u
606.I love u
607.I love u
608.I love u
609.I love u
610.I love u
611.I love u
612.I love u
613.I love u
614.I love u
615.I love u
616.I love u
617.I love u
618.I love u
619.I love u
620.I love u
621.I love u
622.I love u
623.I love u
624.I love u
625.I love u
626.I love u
627.I love u
628.I love u
629.I love u
630.I love u
631.I love u
632.I love u
633.I love u
634.I love u
635.I love u
636.I love u
637.I love u
638.I love u
639.I love u
640.I love u
641.I love u
642.I love u
643.I love u
644.I love u
645.I love u
646.I love u
647.I love u
648.I love u
649.I love u
650.I love u
651.I love u
652.I love u
653.I love u
654.I love u
655.I love u
656.I love u
657.I love u
658.I love u
659.I love u
660.I love u
661.I love u
662.I love u
663.I love u
664.I love u
665.I love u
666.I love u
667.I love u
668.I love u
669.I love u
670.I love u
671.I love u
672.I love u
673.I love u
674.I love u
675.I love u
676.I love u
677.I love u
678.I love u
679.I love u
680.I love u
681.I love u
682.I love u
683.I love u
684.I love u
685.I love u
686.I love u
687.I love u
688.I love u
689.I love u
690.I love u
691.I love u
692.I love u
693.I love u
694.I love u
695.I love u
696.I love u
697.I love u
698.I love u
699.I love u
700.I love u
701.I love u
702.I love u
703.I love u
704.I love u
705.I love u
706.I love u
707.I love u
708.I love u
709.I love u
710.I love u
711.I love u
712.I love u
713.I love u
714.I love u
715.I love u
716.I love u
717.I love u
718.I love u
719.I love u
720.I love u
721.I love u
722.I love u
723.I love u
724.I love u
725.I love u
726.I love u
727.I love u
728.I love u
729.I love u
730.I love u
731.I love u
732.I love u
733.I love u
734.I love u
735.I love u
736.I love u
737.I love u
738.I love u
739.I love u
740.I love u
741.I love u
742.I love u
743.I love u
744.I love u
745.I love u
746.I love u
747.I love u
748.I love u
749.I love u
750.I love u
751.I love u
752.I love u
753.I love u
754.I love u
755.I love u
756.I love u
757.I love u
758.I love u
759.I love u
760.I love u
761.I love u
762.I love u
763.I love u
764.I love u
765.I love u
766.I love u
767.I love u
768.I love u
769.I love u
770.I love u
771.I love u
772.I love u
773.I love u
774.I love u
775.I love u
776.I love u
777.I love u
778.I love u
779.I love u
780.I love u
781.I love u
782.I love u
783.I love u
784.I love u
785.I love u
786.I love u
787.I love u
788.I love u
789.I love u
790.I love u
791.I love u
792.I love u
793.I love u
794.I love u
795.I love u
796.I love u
797.I love u
798.I love u
799.I love u
800.I love u
801.I love u
802.I love u
803.I love u
804.I love u
805.I love u
806.I love u
807.I love u
808.I love u
809.I love u
810.I love u
811.I love u
812.I love u
813.I love u
814.I love u
815.I love u
816.I love u
817.I love u
818.I love u
819.I love u
820.I love u
821.I love u
822.I love u
823.I love u
824.I love u
825.I love u
826.I love u
827.I love u
828.I love u
829.I love u
830.I love u
831.I love u
832.I love u
833.I love u
834.I love u
835.I love u
836.I love u
837.I love u
838.I love u
839.I love u
840.I love u
841.I love u
842.I love u
843.I love u
844.I love u
845.I love u
846.I love u
847.I love u
848.I love u
849.I love u
850.I love u
851.I love u
852.I love u
853.I love u
854.I love u
855.I love u
856.I love u
857.I love u
858.I love u
859.I love u
860.I love u
861.I love u
862.I love u
863.I love u
864.I love u
865.I love u
866.I love u
867.I love u
868.I love u
869.I love u
870.I love u
871.I love u
872.I love u
873.I love u
874.I love u
875.I love u
876.I love u
877.I love u
878.I love u
879.I love u
880.I love u
881.I love u
882.I love u
883.I love u
884.I love u
885.I love u
886.I love u
887.I love u
888.I love u
889.I love u
890.I love u
891.I love u
892.I love u
893.I love u
894.I love u
895.I love u
896.I love u
897.I love u
898.I love u
899.I love u
900.I love u
901.I love u
902.I love u
903.I love u
904.I love u
905.I love u
906.I love u
907.I love u
908.I love u
909.I love u
910.I love u
911.I love u
912.I love u
913.I love u
914.I love u
915.I love u
916.I love u
917.I love u
918.I love u
919.I love u
920.I love u
921.I love u
922.I love u
923.I love u
924.I love u
925.I love u
926.I love u
927.I love u
928.I love u
929.I love u
930.I love u
931.I love u
932.I love u
933.I love u
934.I love u
935.I love u
936.I love u
937.I love u
938.I love u
939.I love u
940.I love u
941.I love u
942.I love u
943.I love u
944.I love u
945.I love u
946.I love u
947.I love u
948.I love u
949.I love u
950.I love u
951.I love u
952.I love u
953.I love u
954.I love u
955.I love u
956.I love u
957.I love u
958.I love u
959.I love u
960.I love u
961.I love u
962.I love u
963.I love u
964.I love u
965.I love u
966.I love u
967.I love u
968.I love u
969.I love u
970.I love u
971.I love u
972.I love u
973.I love u
974.I love u
975.I love u
976.I love u
977.I love u
978.I love u
979.I love u
980.I love u
981.I love u
982.I love u
983.I love u
984.I love u
985.I love u
986.I love u
987.I love u
988.I love u
989.I love u
990.I love u
991.I love u
992.I love u
993.I love u
994.I love u
995.I love u
996.I love u
997.I love u
998.I love u
999.I love u
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  1.995 s
Finished at: 2022-11-25T23:41:26+07:00
------------------------------------------------------------------------

    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lbForgetPass = new javax.swing.JLabel();
        lbExit = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.jLabel1.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.jLabel2.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.jLabel3.text")); // NOI18N

        lbForgetPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbForgetPass.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(lbForgetPass, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.lbForgetPass.text")); // NOI18N
        lbForgetPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbForgetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbForgetPassMouseClicked(evt);
            }
        });

        lbExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbExit.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(lbExit, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.lbExit.text")); // NOI18N
        lbExit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbExitMouseClicked(evt);
            }
        });

        lbClose.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbClose.setForeground(new java.awt.Color(255, 255, 255));
        org.openide.awt.Mnemonics.setLocalizedText(lbClose, org.openide.util.NbBundle.getMessage(QuenMatKhau.class, "QuenMatKhau.lbClose.text")); // NOI18N
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(173, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbForgetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(162, 162, 162)
                                .addComponent(lbClose))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMa)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbClose)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbForgetPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbForgetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbForgetPassMouseClicked
        String ma = txtMa.getText();
        String email = txtEmail.getText();
        
        if(ma.isBlank() || email.isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống");
            return;
        }
        
        String result = nvSer.forgotPass(ma, email);
        JOptionPane.showMessageDialog(this, result);     
    }//GEN-LAST:event_lbForgetPassMouseClicked

    private void lbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbExitMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_lbExitMouseClicked

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_lbCloseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbExit;
    private javax.swing.JLabel lbForgetPass;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    // End of variables declaration//GEN-END:variables
}
