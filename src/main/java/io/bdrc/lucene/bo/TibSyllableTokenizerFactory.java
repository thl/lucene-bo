package io.bdrc.lucene.bo;

import io.bdrc.lucene.stemmer.Trie;
import io.bdrc.lucene.bo.TibSyllableTokenizer;

import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;

import java.util.Map;

public class TibSyllableTokenizerFactory extends TokenizerFactory {

  private final boolean preserveShad;

  public TibSyllableTokenizerFactory(Map<String,String> args) {
    super(args);
    preserveShad = getBoolean(args, "preserveShad", false);
    if (!args.isEmpty()) {
      throw new IllegalArgumentException("Unknown parameters: " + args);
    }
  }

  @Override
  public TibSyllableTokenizer create(AttributeFactory factory) {
    return new TibSyllableTokenizer(preserveShad);
  }
}
