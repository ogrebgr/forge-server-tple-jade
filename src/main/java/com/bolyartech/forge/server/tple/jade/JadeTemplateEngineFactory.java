package com.bolyartech.forge.server.tple.jade;

import com.bolyartech.forge.server.misc.TemplateEngine;
import com.bolyartech.forge.server.misc.TemplateEngineFactory;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.ClasspathTemplateLoader;


public class JadeTemplateEngineFactory implements TemplateEngineFactory {
    private final String mTemplatePathPrefix;
    private final JadeConfiguration mConfiguration;


    public JadeTemplateEngineFactory(String templatePathPrefix, JadeConfiguration configuration) {
        mTemplatePathPrefix = templatePathPrefix;
        mConfiguration = configuration;
        mConfiguration.setTemplateLoader(new ClasspathTemplateLoader());
    }


    public JadeTemplateEngineFactory(String mTemplatePathPrefix) {
        this(mTemplatePathPrefix, new JadeConfiguration());
    }


    @Override
    public TemplateEngine createNew() {
        return new JadeTemplateEngine(mTemplatePathPrefix, mConfiguration);
    }
}
