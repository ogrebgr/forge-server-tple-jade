package com.bolyartech.forge.server.tple.jade;

import com.bolyartech.forge.server.misc.TemplateEngine;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.JadeTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JadeTemplateEngine implements TemplateEngine {
    private final String mTemplatePathPrefix;
    private final JadeConfiguration mConfiguration;
    private final Map<String, Object> mAttributes = new HashMap<>();


    public JadeTemplateEngine(String templatePathPrefix, JadeConfiguration configuration) {
        mTemplatePathPrefix = templatePathPrefix;
        mConfiguration = configuration;
    }


    @Override
    public void assign(String varName, Object object) {
        mAttributes.put(varName, object);
    }


    @Override
    public String render(String templateName) {
        try {
            JadeTemplate template = mConfiguration.getTemplate(mTemplatePathPrefix + templateName);
            return mConfiguration.renderTemplate(template, mAttributes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
