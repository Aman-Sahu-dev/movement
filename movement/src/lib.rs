pub mod domain;
uniffi::setup_scaffolding!();
#[derive(uniffi::Record)]
pub struct Entry {
    pub name: String,
    pub date: String,
    pub present: bool,
}
#[uniffi::export]
fn get_entries() -> Vec<Entry> {
    vec![
        Entry {
            name: "Math".into(),
            date: "12-8-2026".into(),
            present: true,
        },
        Entry {
            name: "Physics".into(),
            date: "12-8-2026".into(),
            present: true,
        },
    ]
}
