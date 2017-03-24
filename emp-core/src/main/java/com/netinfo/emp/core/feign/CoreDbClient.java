package com.netinfo.emp.core.feign;

import com.netinfo.emp.common.WebReturn;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project emp-core
 * Package com.netinfo.emp.core.feign
 * <p>
 * Created by Charley on 2017/3/23.
 */
@FeignClient("EMP-CORE-DB")
public interface CoreDbClient {
    @RequestMapping(value = "/seq_gen_method/{sequence_id}", method = RequestMethod.GET)
    WebReturn seqMethodQuerySeqId(@PathVariable(value = "sequence_id") String sequenceId);

    @RequestMapping(value = "/seq_gen_detail/{sequence_id}/{intermediate_value}", method = RequestMethod.GET)
    WebReturn seqDetailQuerySeqIdAndInterValue(@PathVariable(value = "sequence_id") String sequenceId,
                                               @PathVariable(value = "intermediate_value") String intermediateValue);

    @RequestMapping(value = "/seq_gen_detail", method = RequestMethod.POST)
    WebReturn seqDetailAdd(@RequestParam(value = "sequence_id") String sequenceId,
                           @RequestParam(value = "intermediate_value") String intermediateValue,
                           @RequestParam(value = "current_value") String currentValue,
                           @RequestParam(value = "final_acquisition_time", required = false, defaultValue = "0") String finalAcquisitionTime);

    @RequestMapping(value = "/accounts/account/{account}", method = RequestMethod.GET)
    WebReturn accountBasicQueryAccount(@PathVariable(value = "account") String account);

    @RequestMapping(value = "/logins/{login_id}", method = RequestMethod.GET)
    WebReturn loginQueryLoginId(@PathVariable(value = "login_id") String loginId);

    @RequestMapping(value = "/logins/account_id/{account_id}", method = RequestMethod.GET)
    WebReturn loginQueryAccountId(@PathVariable(value = "account_id") String accountId);

    @RequestMapping(value = "/logins", method = RequestMethod.POST)
    WebReturn loginAdd(@RequestParam(value = "login_id") String loginId,
                       @RequestParam(value = "account_id") String accountId,
                       @RequestParam(value = "login_time") String loginTime,
                       @RequestParam(value = "login_result") String loginResult,
                       @RequestParam(value = "token_key") String tokenKey,
                       @RequestParam(value = "login_host") String loginHost,
                       @RequestParam(value = "login_address") String loginAddress,
                       @RequestParam(value = "exited") String isExited,
                       @RequestParam(value = "exited_method") String exitedMethod,
                       @RequestParam(value = "exited_time") String exitedTime,
                       @RequestParam(value = "last_interactive_time") String lastInteractiveTime);

    @RequestMapping(value = "/lang_types", method = RequestMethod.GET)
    WebReturn langTypeList();

    @RequestMapping(value = "/lang_types/lang_id/{lang_id}", method = RequestMethod.GET)
    WebReturn langTypeQueryLangId(@PathVariable(value = "lang_id") short langId);

    @RequestMapping(value = "/lang_infos/lang_id/{lang_id}", method = RequestMethod.GET)
    WebReturn langInfoQueryLangId(@PathVariable(value = "lang_id") short langId);

    @RequestMapping(value = "/lang_infos/lang_id/{lang_id}/module_number/{module_number}", method = RequestMethod.GET)
    WebReturn langInfoQueryLangIdModuleNumber(@PathVariable(value = "lang_id") short langId,
                                              @PathVariable(value = "module_number") short moduleNumber);

    @RequestMapping(value = "/lang_infos/lang_id/{lang_id}/page_name/{page_name}", method = RequestMethod.GET)
    WebReturn langInfoQueryLangIdPageName(@PathVariable(value = "lang_id") short langId,
                                          @PathVariable(value = "page_name") String pageName);
}
