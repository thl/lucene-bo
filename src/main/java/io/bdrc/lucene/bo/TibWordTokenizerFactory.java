package io.bdrc.lucene.bo;

import io.bdrc.lucene.stemmer.Trie;
import io.bdrc.lucene.bo.TibWordTokenizer;

import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;

import java.util.Map;

public class TibWordTokenizerFactory extends TokenizerFactory {
  private final int maxTokenLen;

  public TibWordTokenizerFactory(Map<String,String> args) {
    super(args);
    maxTokenLen = getInt(args, "maxTokenLen", TibWordTokenizer.MAX_WORD_LEN);
    if (!args.isEmpty()) {
      throw new IllegalArgumentException("Unknown parameters: " + args);
    }
  }

  @Override
  public TibWordTokenizer create(AttributeFactory factory) throws IllegalStateException {
    try {
      return new TibWordTokenizer();
    } catch (FileNotFoundException e) {
      throw new IllegalStateException();
    } catch (IOException e) {
      throw new IllegalStateException();
    }
  }
}
