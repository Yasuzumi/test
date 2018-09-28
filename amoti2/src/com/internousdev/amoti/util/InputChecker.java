package com.internousdev.amoti.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	public List<String> doCheck(String propertyName,String value,int minLength,int maxLength,boolean availableAlphabeticCharacters,boolean availableKanji,boolean availableHiragana,boolean availableHalfWidthDigit,boolean availableHalfWidthSymbols,boolean availableKatakana,boolean availableFullWidthSymbols,boolean availableFullWidthDigit,boolean availableFullWidthAlphabet){

		List<String> stringList = new ArrayList<String>();
		List<String> characterTypeList = new ArrayList<String>();

		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName + "を入力してください。");
		}

		if(value.length() < minLength || value.length() > maxLength){
			stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
		}

		String regularExpression = "";
		String errorExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols||availableFullWidthDigit||availableFullWidthAlphabet){
			regularExpression = "[^";
		}
		if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) || !(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)|| !(availableFullWidthDigit)|| !(availableFullWidthAlphabet)){
			errorExpression = "[^";
		}

		if(availableAlphabeticCharacters){
			regularExpression +="a-zA-Z";
				characterTypeList.add("半角英字");
		}else{
			errorExpression += "a-zA-Z";
		}

		if(availableKanji){
			regularExpression +="一-龯";
			characterTypeList.add("漢字");
		}else{
			errorExpression +="一-龯";
		}

		if(availableHiragana){
			regularExpression +="ぁ-ん";
			characterTypeList.add("ひらがな");
		}else{
			errorExpression +="ぁ-ん";
		}

		if(availableHalfWidthDigit){
			regularExpression +="0-9";
			characterTypeList.add("半角数字");
		}else{
			errorExpression+="0-9";
		}

		if(availableHalfWidthSymbols){
			regularExpression +="@.,;:!#$%&'*+-/=?^_`{|}~()<>\\ ";
			characterTypeList.add("半角記号");
		}else{
			errorExpression +="@.,;:!#$%&'*+-/=?^_`{|}~()<>\\ ";
		}

		if(availableKatakana){
			regularExpression +="ァ-ヺ";
			characterTypeList.add("カタカナ");
		}else{
			errorExpression +="ァ-ヺ";
		}

		if(availableFullWidthSymbols){
			regularExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～（）「」”￥　";
			characterTypeList.add("全角記号");
		}else{
			errorExpression +="＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～（）「」”￥　";
		}

		if(availableFullWidthDigit){
			regularExpression +="０-９";
			characterTypeList.add("全角数字");
		}else{
			errorExpression+="０-９";
		}

		if(availableFullWidthAlphabet){
			regularExpression +="ａ-ｚＡ-Ｚ";
			characterTypeList.add("全角英字");
		}else{
			errorExpression+="ａ-ｚＡ-Ｚ";
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression +="]+";
		}
		if(!StringUtils.isEmpty(errorExpression)){
			errorExpression +="]+";
		}

		String characterType = "";
		for(int i = 0;i < characterTypeList.size();i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}
		if(errorExpression.equals("")){
			if(value.matches(regularExpression)){
				stringList.add(propertyName + "は" + characterType + "で入力してください。");
			}
		}else{
			if(value.matches(regularExpression)||(!value.matches(errorExpression)&&!value.equals(""))){
				stringList.add(propertyName + "は" + characterType + "で入力してください。");
			}
		}

		return stringList;
	}
	public List<String> doCheck2(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana,
			boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana,
			boolean availableFullWidthSymbols) {

		List<String> resultList = new ArrayList<String>(); // 結果
		List<String> messageList = new ArrayList<String>(); // メッセージ

		// ①入力内容が空欄かどうか
		if (StringUtils.isEmpty(value)) {
			resultList.add(propertyName + "を入力してください");
		}

		// ②入力文字数内に収まっているかどうか
		if ((value.length() < minLength || value.length() > maxLength) && (!(StringUtils.isEmpty(value)))) {
			resultList.add(propertyName + "は、" + minLength + "桁以上" + maxLength + "桁以下で入力してください");
		}

		// ③こちらの意図した文字列が入力されているか
		String regularExpression = ""; // 正しい表現

		// まず始まりの括弧
		if (availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits
				|| availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols) {
			regularExpression += "[";
		}

		// 半角英字は使用可能かどうか
		if (availableAlphabeticCharacters) {
			regularExpression += "a-zA-Z";
			messageList.add("半角英字");
		}

		// 漢字は使用可能かどうか
		if (availableKanji) {
			regularExpression += "一-龯";
			messageList.add("漢字");
		}

		// ひらがなは使用可能かどうか
		if (availableHiragana) {
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}

		// 半角数字は使用可能かどうか
		if (availableHalfWidthDigits) {
			regularExpression += "0-9";
			messageList.add("半角数字");
		}

		// 半角記号は使用可能かどうか
		if (availableHalfWidthSymbols) {
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~() ";
			messageList.add("半角記号");
		}

		// カタカナは使用可能かどうか
		if (availableKatakana) {
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}

		// 全角記号は使用可能かどうか
		if (availableFullWidthSymbols) {
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～ー、。　";
			messageList.add("全角記号");
		}

		// 括弧を閉じる。これでそれぞれ"[^○○○]+"の形になる。
		if (!StringUtils.isEmpty(regularExpression)) {
			regularExpression += "]+";
		}

		String message = "";
		for (int i = 0; i < messageList.size(); i++) {
			if (i == 0) {
				message += messageList.get(i).toString();
			} else {
				message += "、" + messageList.get(i).toString();
			}
		}

		// 入力された値を正しい表現、誤った表現と比較し状況に応じてエラーメッセージを返す
		if (regularExpression.equals("")) {
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		} else {
			if ((!value.matches(regularExpression) && !value.equals(""))) {
				resultList.add(propertyName + "は、" + message + "で入力してください。");
			}
		}
		return resultList;
	}

	public List<String> doCheck3(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana,
			boolean availableHalfWidthDigits, boolean availableHalfWidthSymbols, boolean availableKatakana,
			boolean availableFullWidthSymbols) {

		List<String> resultList = new ArrayList<String>(); // 結果
		List<String> messageList = new ArrayList<String>(); // メッセージ

		// ②入力文字数内に収まっているかどうか
		if ((value.length() < minLength || value.length() > maxLength) && (!(StringUtils.isEmpty(value)))) {
			resultList.add(propertyName + "は、" + minLength + "文字以上" + maxLength + "文字以下で挿入してください");
		}

		// ③こちらの意図した文字列が入力されているか
		String regularExpression = ""; // 正しい表現

		// まず始まりの括弧
		if (availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigits
				|| availableHalfWidthSymbols || availableKatakana || availableFullWidthSymbols) {
			regularExpression += "[";
		}

		// 半角英字は使用可能かどうか
		if (availableAlphabeticCharacters) {
			regularExpression += "a-zA-Z";
			messageList.add("半角英字");
		}

		// 漢字は使用可能かどうか
		if (availableKanji) {
			regularExpression += "一-龯";
			messageList.add("漢字");
		}

		// ひらがなは使用可能かどうか
		if (availableHiragana) {
			regularExpression += "ぁ-ん";
			messageList.add("ひらがな");
		}

		// 半角数字は使用可能かどうか
		if (availableHalfWidthDigits) {
			regularExpression += "0-9";
			messageList.add("半角数字");
		}

		// 半角記号は使用可能かどうか
		if (availableHalfWidthSymbols) {
			regularExpression += "@.,;:!#$%&'*+-/=?^_`{|}~() ";
			messageList.add("半角記号");
		}

		// カタカナは使用可能かどうか
		if (availableKatakana) {
			regularExpression += "ァ-ヺ";
			messageList.add("カタカナ");
		}

		// 全角記号は使用可能かどうか
		if (availableFullWidthSymbols) {
			regularExpression += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～ー、。　";
			messageList.add("全角記号");
		}

		// 括弧を閉じる。これでそれぞれ"[^○○○]+"の形になる。
		if (!StringUtils.isEmpty(regularExpression)) {
			regularExpression += "]+";
		}

		String message = "";
		for (int i = 0; i < messageList.size(); i++) {
			if (i == 0) {
				message += messageList.get(i).toString();
			} else {
				message += "、" + messageList.get(i).toString();
			}
		}

		// 入力された値を正しい表現、誤った表現と比較し状況に応じてエラーメッセージを返す
		if (regularExpression.equals("")) {
			resultList.add(propertyName + "は、" + message + "で入力してください。");
		} else {
			if ((!value.matches(regularExpression) && !value.equals(""))) {
				resultList.add(propertyName + "は、" + message + "で入力してください。");
			}
		}
		return resultList;
	}

	public List<String> doPasswordCheck(String password,String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(password.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります。");
		}
		return stringList;
	}
}
