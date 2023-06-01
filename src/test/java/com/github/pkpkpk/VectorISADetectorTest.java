package com.github.pkpkpk;


import com.github.pkpkpk.detectvectorisa.VectorISADetector;

public class VectorISADetectorTest {
    public static void main(String[] args) {
        VectorISADetector detector = new VectorISADetector();
        System.out.println(detector.summarizeVectorSupport());
    }
}
