/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JDialogVoiceTalk.java
 *
 * Created on 2009-11-30, 20:42:14
 */

/**
 *
 * @author Administrator
 */

package cilent;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import sdk.HCNetSDK;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogVoiceTalk extends javax.swing.JDialog
{

	static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
	NativeLong m_lUserID;
	HCNetSDK.NET_DVR_DEVICEINFO_V30 m_strDeviceInfo;
	HCNetSDK.NET_DVR_WORKSTATE_V30 m_strWorkState;
	FVoiceDataCallBack fVoiceDataCallBack;
	int m_iSel;
	boolean m_bInitialed;

	FileWriter fLocal;
	FileWriter fDevice;

	public DialogVoiceTalk(java.awt.Frame parent, boolean modal, NativeLong lUserID,
			HCNetSDK.NET_DVR_DEVICEINFO_V30 strDeviceInfo)
	{
		super(parent, modal);
		try
		{
			initComponents();
			m_lUserID = lUserID;
			m_strDeviceInfo = strDeviceInfo;
			m_iSel = 0;
			fVoiceDataCallBack = new FVoiceDataCallBack();
			fLocal = new FileWriter("D:\\local.264");
			fDevice = new FileWriter("D:\\device.264");

			initialDialog();
			m_bInitialed = true;
		}
		catch (IOException ex)
		{
			Logger.getLogger(DialogVoiceTalk.class.getName()).log(Level.SEVERE, null, ex);
		}
		setModal(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents()
	{

		jPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jComboBoxVoiceChannel = new javax.swing.JComboBox();
		jComboBoxVoiceChannel.setModel(new DefaultComboBoxModel(new String[] { "Audio1" }));
		jLabelStatus = new javax.swing.JLabel();
		jButtonStart = new javax.swing.JButton();
		jButtonStop = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jComboBoxDataType = new javax.swing.JComboBox();
		jButtonRefresh = new javax.swing.JButton();
		jButtonExit = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("VoiceTalk");

		jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jLabel1.setText("Talk Chan");

		jComboBoxVoiceChannel.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jComboBoxVoiceChannelActionPerformed(evt);
			}
		});

		jLabelStatus.setText("not used");

		jButtonStart.setText("Start");
		jButtonStart.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButtonStartActionPerformed(evt);
			}
		});

		jButtonStop.setText("Stop");
		jButtonStop.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButtonStopActionPerformed(evt);
			}
		});

		jLabel2.setText("CallBack Data Type");

		jComboBoxDataType.setModel(new DefaultComboBoxModel(new String[] { "DisPCM", "PCM" }));

		GroupLayout jPanelLayout = new GroupLayout(jPanel);
		jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(jPanelLayout
				.createSequentialGroup()
				.addGroup(jPanelLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanelLayout.createSequentialGroup().addGap(18)
								.addGroup(jPanelLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(jPanelLayout.createSequentialGroup().addComponent(jButtonStart)
												.addGap(36).addComponent(jButtonStop))
								.addGroup(jPanelLayout.createSequentialGroup().addComponent(jLabel1).addGap(18)
										.addComponent(jComboBoxVoiceChannel, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(jLabelStatus))))
						.addGroup(jPanelLayout.createSequentialGroup().addGap(86).addComponent(jLabel2)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jComboBoxDataType,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(jPanelLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(jPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel1)
						.addComponent(jComboBoxVoiceChannel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabelStatus))
				.addGap(18)
				.addGroup(jPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(jButtonStart)
						.addComponent(jButtonStop))
				.addGap(18)
				.addGroup(jPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2).addComponent(
						jComboBoxDataType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel.setLayout(jPanelLayout);

		jButtonRefresh.setText("Refresh");
		jButtonRefresh.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButtonRefreshActionPerformed(evt);
			}
		});

		jButtonExit.setText("Exit");
		jButtonExit.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				jButtonExitActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addComponent(jButtonRefresh)
								.addPreferredGap(ComponentPlacement.RELATED, 97,
										Short.MAX_VALUE)
								.addComponent(jButtonExit).addGap(40, 40, 40))
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jButtonRefresh).addComponent(jButtonExit))
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt)
	{
		Client.g_lVoiceHandle = hCNetSDK.NET_DVR_StartVoiceCom_V30(m_lUserID, m_iSel + 1,
				jComboBoxDataType.getSelectedIndex() == 1, fVoiceDataCallBack, null);
		if (Client.g_lVoiceHandle.intValue() == -1)
		{
			DialogMessage dlg = new DialogMessage("VoiceTalk failed,error code:" + hCNetSDK.NET_DVR_GetLastError());
			dlg.setBounds(0, 0, 370, 200);
			dlg.setVisible(true);
			return;
		}
		EnableCtrl();

	}

	private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt)
	{
		if (Client.g_lVoiceHandle.intValue() >= 0)
		{
			if (hCNetSDK.NET_DVR_StopVoiceCom(Client.g_lVoiceHandle))
			{
				Client.g_lVoiceHandle.setValue(-1);
			}
			else
			{
				DialogMessage dlg = new DialogMessage(
						"Close voice talk failed,error code:" + hCNetSDK.NET_DVR_GetLastError());
				dlg.setBounds(0, 0, 370, 200);
				dlg.setVisible(true);
			}
		}
		EnableCtrl();
	}

	private void jComboBoxVoiceChannelActionPerformed(java.awt.event.ActionEvent evt)
	{
		if (!m_bInitialed)
		{
			return;
		}
		m_iSel = jComboBoxVoiceChannel.getSelectedIndex();
		if (0 == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setText("Not use");
			jLabelStatus.setVisible(true);
		}
		else if (1 == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setText("use");
			jLabelStatus.setVisible(true);
		}
		else if (0xff == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setVisible(false);
		}
	}

	private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt)
	{
		if (!hCNetSDK.NET_DVR_GetDVRWorkState_V30(m_lUserID, m_strWorkState))
		{

			DialogMessage dlg = new DialogMessage(
					"Get work progress failed,error code:" + hCNetSDK.NET_DVR_GetLastError());
			dlg.setBounds(0, 0, 370, 200);
			dlg.setVisible(true);
			jLabelStatus.setVisible(false);
			return;
		}

		m_iSel = jComboBoxVoiceChannel.getSelectedIndex();
		if (0 == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setText("not use");
			jLabelStatus.setVisible(true);
		}
		else if (1 == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setText("use");
			jLabelStatus.setVisible(true);
		}
		else if (0xff == m_strWorkState.byAudioChanStatus[m_iSel])
		{
			jLabelStatus.setVisible(false);
		}
	}

	private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt)
	{
		dispose();
	}

	private void initialDialog()
	{
		EnableCtrl();
		switch (m_strDeviceInfo.byAudioChanNum)
		{
		case 1:
			jComboBoxVoiceChannel.addItem("Audio1");
			break;
		case 2:
			jComboBoxVoiceChannel.addItem("Audio1");
			jComboBoxVoiceChannel.addItem("Audio2");
			break;
		default:
			break;
		}

		m_strWorkState = new HCNetSDK.NET_DVR_WORKSTATE_V30();
		if (!hCNetSDK.NET_DVR_GetDVRWorkState_V30(m_lUserID, m_strWorkState))
		{
			DialogMessage dlg = new DialogMessage(
					"Get work progress failed,error code:" + hCNetSDK.NET_DVR_GetLastError());
			dlg.setBounds(0, 0, 370, 200);
			dlg.setVisible(true);
			jLabelStatus.setVisible(false);
		}
		else
		{

			if (0 == m_strWorkState.byAudioChanStatus[m_iSel])
			{
				jLabelStatus.setText("not use");
				jLabelStatus.setVisible(true);
			}
			else
			{
				if (1 == m_strWorkState.byAudioChanStatus[m_iSel])
				{
					jLabelStatus.setText("use");
					jLabelStatus.setVisible(true);
				}
				else
				{
					if (0xff == m_strWorkState.byAudioChanStatus[m_iSel])
					{
						jLabelStatus.setVisible(false);
					}
				}
			}
		}
	}

	private void EnableCtrl()
	{
		boolean bVoiceTalk = false;
		if (Client.g_lVoiceHandle.intValue() >= 0)
		{
			bVoiceTalk = true;
			jLabelStatus.setText("use");
		}
		else
		{
			bVoiceTalk = false;
			jLabelStatus.setText("not use");
		}
		jButtonStart.setEnabled(!bVoiceTalk);
		jButtonStop.setEnabled(bVoiceTalk);
		jComboBoxVoiceChannel.setEnabled(!bVoiceTalk);
	}

	private javax.swing.JButton jButtonExit;
	private javax.swing.JButton jButtonRefresh;
	private javax.swing.JButton jButtonStart;
	private javax.swing.JButton jButtonStop;
	private javax.swing.JComboBox jComboBoxDataType;
	private javax.swing.JComboBox jComboBoxVoiceChannel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabelStatus;
	private javax.swing.JPanel jPanel;

	class FVoiceDataCallBack implements HCNetSDK.FVoiceDataCallBack_V30
	{

		public void invoke(NativeLong lVoiceComHandle, String pRecvDataBuffer, int dwBufSize, byte byAudioFlag,
				Pointer pUser)
		{

			if (byAudioFlag == 0)
			{
				try
				{
					fLocal.write(pRecvDataBuffer);
					fLocal.flush();
				}
				catch (IOException ex)
				{
					Logger.getLogger(DialogVoiceTalk.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			else
			{
				if (byAudioFlag == 1)
				{
					try
					{
						fDevice.write(pRecvDataBuffer);
						fDevice.flush();
					}
					catch (IOException ex)
					{
						Logger.getLogger(DialogVoiceTalk.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
		}
	}

}
