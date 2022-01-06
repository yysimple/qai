package com.simple.page.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.simple.page.domain.SingleTable;
import com.simple.page.service.SingleTableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (SingleTable)表控制层
 *
 * @author makejava
 * @since 2022-01-06 17:41:52
 */
@RestController
@RequestMapping("singleTable")
public class SingleTableController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SingleTableService singleTableService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param singleTable 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SingleTable> page, SingleTable singleTable) {
        return success(this.singleTableService.page(page, new QueryWrapper<>(singleTable)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.singleTableService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param singleTable 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SingleTable singleTable) {
        return success(this.singleTableService.save(singleTable));
    }

    /**
     * 修改数据
     *
     * @param singleTable 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SingleTable singleTable) {
        return success(this.singleTableService.updateById(singleTable));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.singleTableService.removeByIds(idList));
    }
}

