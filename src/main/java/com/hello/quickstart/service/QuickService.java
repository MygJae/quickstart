package com.hello.quickstart.service;

import com.hello.quickstart.dto.ItemDto;
import com.hello.quickstart.entity.ItemEntity;
import com.hello.quickstart.mapper.QuickMapper;
import com.hello.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    private final QuickMapper quickMapper;

    private final ItemRepository itemRepository;

    @Autowired
    public QuickService(QuickMapper quickMapper, ItemRepository itemRepository) {
        this.quickMapper = quickMapper;
        this.itemRepository = itemRepository;
    }

    //Mybatis
    /*
    public boolean ItemFrom(ItemDto itemDto) {

        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        quickMapper.regItem(paramMap);

        log.info("service");
        return true;
    }
    */

    /*
    public ItemDto getItemById(String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        HashMap<String, Object> res = quickMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String) res.get("ID"));
        itemDto.setName((String) res.get("NAME"));
        return itemDto;
    }
    */

    //JPA
    public ItemDto getItemById(String id) {

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }

    public boolean ItemFrom(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }

}

