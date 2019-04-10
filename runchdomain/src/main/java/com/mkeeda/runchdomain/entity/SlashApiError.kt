package com.mkeeda.runchdomain.entity

enum class SlashApiError(val rawValue: String) {
    /// バリデーションエラー（ログイン時は、ログイン名orパスワードが不正）
    CB_VA01("CB_VA01"),
    /// パスワードの有効期限切れ
    CB_PE01("CB_PE01"),
    /// オンプレ移行直後のログインで発生
    CB_PL01("CB_PL01"),
    /// アカウントロック
    CB_US02("CB_US02"),
    /// サービスの利用権限がない
    CB_NO02("CB_NO02"),
    /// 「ログインしてください」のエラー
    CB_AU01("CB_AU01"),
    /// セッショントークン切れのエラー
    CB_CS01("CB_CS01"),
    /// セキュアアクセスの証明書がログインを試行したユーザーのものでない
    SLASH_IL06("SLASH_IL06"),
    /// 認証情報が間違っている
    SLASH_LO02("SLASH_LO02"),
    /// 「管理者が設定した仮パスワードの変更をユーザーに要求する」の設定の影響
    SLASH_PA02("SLASH_PA02")
}
