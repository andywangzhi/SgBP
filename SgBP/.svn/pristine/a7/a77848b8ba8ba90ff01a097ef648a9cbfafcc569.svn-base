package com.gzepro.internal.query.soa.action.rcsm.affix;

import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.dto.rcsm.affix.RsAffixDTO;
import com.gzepro.internal.query.soa.service.user.impl.RsAffixService;

/**
 * 
  * @ClassName: RsPersonAction
  * @Description: TODO(后台业务系统附件Action类)
  * @author 刘俊明
  *
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.RsAffixAction")
public class RsAffixAction extends SoaBaseJsonAction {

	public String affixId;

	@Resource
	private RsAffixService rsAffixService;
	
	/**
	 * 显示图片
	 * @return
	 */
	public String showImage() {
		if(affixId != null && affixId.trim().length() > 0) {
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				List<RsAffixDTO> dtoList = (List<RsAffixDTO>) rsAffixService.queryByRsAffixId(affixId, menuId, this.getAccount().getId());
				if(dtoList != null && dtoList.size() > 0) {
					RsAffixDTO dto = dtoList.get(0);
					if(dto != null && dto.getAffixContext() != null && dto.getAffixContext().length > 0) {
						response.setContentType("image/jpeg");
						response.setHeader("Pragma", "NO-cache");
						response.setHeader("Cache-Control", "no-cache");
						response.setDateHeader("Expires", 0);
						OutputStream out = response.getOutputStream();
						out.write(dto.getAffixContext());     
						out.flush();
						out.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}

	/**
	 * 下载文件
	 * @return
	 */
	public String downFile() {
		if(affixId != null && affixId.trim().length() > 0) {
			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				List<RsAffixDTO> dtoList = (List<RsAffixDTO>) rsAffixService.queryByRsAffixId(affixId, menuId, this.getAccount().getId());
				if(dtoList != null && dtoList.size() > 0) {
					RsAffixDTO dto = dtoList.get(0);
					if(dto != null && dto.getAffixContext() != null && dto.getAffixContext().length > 0) {
						String fileName = dto.getAffixName();
						fileName = new String(fileName.getBytes("GBK"), "ISO8859-1");
						response.reset();
						response.setContentType("application/x-msdownload");
						response.setHeader("Pragma", "NO-cache");
						response.setHeader("Cache-Control", "no-cache");
						response.setDateHeader("Expires", 0);
						response.addHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");

						OutputStream out = response.getOutputStream();
						out.write(dto.getAffixContext());     
						out.flush();
						out.close();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}

	public String getAffixId() {
		return affixId;
	}

	public void setAffixId(String affixId) {
		this.affixId = affixId;
	}
}
