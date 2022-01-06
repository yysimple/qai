package com.simple.page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.simple.page.mapper.SingleTableMapper;
import com.simple.page.domain.SingleTable;
import com.simple.page.service.SingleTableService;
import org.springframework.stereotype.Service;

/**
 * (SingleTable)表服务实现类
 *
 * @author makejava
 * @since 2022-01-06 17:41:55
 */
@Service("singleTableService")
public class SingleTableServiceImpl extends ServiceImpl<SingleTableMapper, SingleTable> implements SingleTableService {

}

